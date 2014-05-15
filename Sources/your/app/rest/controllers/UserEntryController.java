package your.app.rest.controllers;

import your.app.model.UserEntry;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;
import er.rest.routes.ERXRouteController;
import er.rest.routes.jsr311.GET;
import er.rest.routes.jsr311.POST;
import er.rest.routes.jsr311.Path;
import er.rest.routes.jsr311.PathParam;

public class UserEntryController extends ERXRouteController {

  public UserEntryController(WORequest request) {
    super(request);
  }

  /**
   * Some sort of filter. Not quite got the hang of this yet.
   * 
   * @return
   */
  protected ERXKeyFilter filter() {
    /* Create a filter */
    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    
    /* Allow updating of nested objects. */
    filter.setAnonymousUpdateEnabled(true);
    
    /* Include the file name */
    // TODO: I don't think this actually does anything... (it's included anyway?)
    filter.include(UserEntry.USER_NAME);
    
    /* If you supply a key which doesn't exist, throw an error. */
    filter.setUnknownKeyIgnored(false);

    return filter;
  }

  @GET
  @Path("/UserEntry")
  public WOActionResults getAll() {
    NSArray<UserEntry> entries = UserEntry.fetchAllUserEntries(editingContext());
    return response(entries, filter());
  }
  
  @GET
  @Path("/UserEntry/{userId:Integer}")
  public WOActionResults employeesAction(@PathParam("userId") Integer userId) {
    NSArray<UserEntry> entries = UserEntry.fetchAllUserEntries(editingContext());
    return response(entries, filter());
  }
  
  @POST
  @Path("/UserEntry")
  public WOActionResults newOne() {
    UserEntry entry = create("UserEntry", filter());
    editingContext().saveChanges();
    return response(entry, filter());
  }
  
}