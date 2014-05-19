package your.app;

import your.app.rest.controllers.FileEntryController;
import your.app.rest.controllers.UserEntryController;
import er.extensions.appserver.ERXApplication;
import er.rest.routes.ERXRouteRequestHandler;

public class Application extends ERXApplication {
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Brace Yourselves: Sam's WOnderful Demo is starting!");
		
		
    setDefaultRequestHandler(requestHandlerForKey(directActionRequestHandlerKey()));
    
		/* ** Begin Initialization Code ** */
		
    ERXRouteRequestHandler handler = new ERXRouteRequestHandler(ERXRouteRequestHandler.WO);

    // User Controller
    handler.addRoutes(UserEntryController.class);
    // File Controller
    handler.addRoutes(FileEntryController.class);
    
    ERXRouteRequestHandler.register(handler);
    
    /* ** End Initialization Code ** */
    
		setAllowsConcurrentRequestHandling(true);		
	}
}