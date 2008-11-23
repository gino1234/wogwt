package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface HelloService extends RemoteService {
	
	public static class Util {
		public static HelloServiceAsync getInstance() {
			HelloServiceAsync service = (HelloServiceAsync)GWT.create(HelloService.class);
			((ServiceDefTarget)service).setServiceEntryPoint(WOGWTClientUtil.rpcUrl());
			return service;
		}
	}

	public String hello();
	
}