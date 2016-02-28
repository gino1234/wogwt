## Summary ##

WOGWT is a WebObjects framework that provides everything needed for integration with GWT (Google Web Toolkit).  GWT allows you to write java code that is compiled into static javascript and runs inside your WebObjects pages.

WOGWT is an alternative to (or compliment to!) the Ajax.framework in Project Wonder.  GWT is basically an AJAX framework in the end.  GWT is different than other AJAX frameworks in this way: rather than providing lots of canned functionality GWT enables you, an average joe, to implement the kind of javascipt that only a js guru could write.

## Getting Started ##

  1. Download WOGWT and install WOGWT.framework into /Library/Frameworks/.  This is necessary even if you plan on using the WOGWT source.
  1. Install the Google Eclipse Plugin by following their [instructions](http://code.google.com/eclipse/docs/getting_started.html#installing).  You don't need to download a GWT SDK since it is included in WOGWT.  You will have to configure the GWT SDK location in eclipse preferences to point to the folder /Library/Frameworks/WOGWT.framework/Resources/Java/
  1. Run "WOGWT.framework/Resources/wogwt-tool.jar" by double-clicking it.  Follow the instructions on the screen.  This app will generate and modify necessary files for you.
  1. To launch your project in GWT Development Mode run the generated ProjectName\_GWTDevMode.launch file in your project folder.

## Running and Debugging your application ##

GWT runs in different modes for development and production. In production GWT compiles into static javascript files that served as WebServerResources by your application, which is all very normal. This is called web mode.

But during development you run your code in GWT Development Mode. This launch configuration (generated by WOGWT-Tool.jar) enables you to debug your GWT code as pure Java instead of compiling it to JavaScript. All your WO code will continue to work in this environment too.

If you don't need to debug your GWT code, then you can run your app the way your always do (as a WOApplication). You just have to compile the GWT code to JavaScript. You can do this by running the "gwt-compile-dev" ant build target. This does a development compile, which is faster than the full compile (gwt-compile) because it only generates unoptimized code to support a single browser and locale (safari and english).

## Adding GWT to pages ##

WOGWT-Tool.jar will add a WOGWTScript component into your Main component by default. If you have other pages that you want to use GWT you will need to add a WOGWTScript component to each page (or to your PageWrapper).

WOGWT is loaded into a page by including a WOGWTScript component in the body of the page, like this:
Main.html
```
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<html>
<head>
	<title>Untitled</title>
</head>
<body>
	Hello World
	<webobject name="WOGWTScript"/>
</body>
</html>
```

Main.wod
```
WOGWTScript : WOGWTScript {
	module = "your.app.gwt.Application";
	enableHistorySupport = "true";
}
```

## Compiling and deploying your application ##

Your GWT code can be compiled to JavaScript by running the ant task "gwt-compile" in your build.xml file. The gwt-compile task will generate static javascript files in your WebServerResources folder.

After your GWT code is compiled to javascript you can run and deply your WOApplication like you always do.