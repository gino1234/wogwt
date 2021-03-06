package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.UpdateOnClickListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;

public class DynamicUIScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("DynamicUI")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		Hyperlink gwtCreatedLink = new Hyperlink();
		gwtCreatedLink.setText("Count");
		gwtCreatedLink.addClickHandler(
				new UpdateOnClickListener("countAction", "countContainer", null));
		RootPanel.get("linkContainer").add(gwtCreatedLink);
	}
	
}
