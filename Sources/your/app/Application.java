package your.app;

import your.app.model.FileEntry;
import your.app.model.UserEntry;
import er.extensions.appserver.ERXApplication;
import er.rest.routes.ERXRouteRequestHandler;

public class Application extends ERXApplication {
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		
		/* ** Begin Initialization Code ** */
		
		// Add handler for each controller
    ERXRouteRequestHandler handler = new ERXRouteRequestHandler();
    // User Controller
    handler.addDefaultRoutes(UserEntry.ENTITY_NAME);
    // File Controller
    handler.addDefaultRoutes(FileEntry.ENTITY_NAME);
    ERXRouteRequestHandler.register(handler);
    
    /* ** End Initialization Code ** */
    
		setAllowsConcurrentRequestHandling(true);		
	}
}
