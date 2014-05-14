package your.app.rest.controllers;

import your.app.model.UserEntry;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;
import er.rest.routes.ERXRouteController;
import er.rest.routes.jsr311.GET;
import er.rest.routes.jsr311.Path;
import er.rest.routes.jsr311.PathParam;

public class UserEntryController extends ERXRouteController {

  public UserEntryController(WORequest request) {
    super(request);
  }

  protected ERXKeyFilter filter() {
    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    // Allow nested entities to be modified without specifying their id
    filter.setAnonymousUpdateEnabled(true);
    filter.include(UserEntry.USER_NAME);

    return filter;
  }

  /**
   * Returns a temporary UserEntry, one that is not saved permanently.
   * 
   * @return
   * @throws Throwable
   */
  public WOActionResults newAction() throws Throwable {
    return null;
  }

  /**
   * Updates a UserEntry.
   * 
   * @param userEntry
   * @return
   * @throws Throwable
   */
  public WOActionResults updateAction(@PathParam("userEntry") UserEntry userEntry) throws Throwable {
    return null;
  }

  /**
   * Deletes a UserEntry.
   * 
   * @param userEntry
   * @return
   * @throws Throwable
   */
  public WOActionResults destroyAction(@PathParam("userEntry") UserEntry userEntry) throws Throwable {
    return null;
  }

  /**
   * Gets a UserEntry.
   * 
   * @param userEntry
   * @return
   * @throws Throwable
   */
  public WOActionResults showAction(@PathParam("userEntry") UserEntry userEntry) throws Throwable {
    return response(userEntry, filter());
  }

  /**
   * Creates a new UserEntry, stores it permanently.
   * 
   * @return
   * @throws Throwable
   */
  public WOActionResults createAction() throws Throwable {
    UserEntry entry = create(filter());
    editingContext().saveChanges();
    return response(entry, filter());
  }

  /**
   * Gets all UserEntry(s).
   * @return
   * @throws Throwable
   */
  public WOActionResults indexAction() throws Throwable {
    NSArray<UserEntry> entries = UserEntry.fetchAllUserEntries(editingContext());
    return response(entries, filter());
  }
  
  /* Custom Routes, like Jersey. I miss Jersey... :-( */
  @GET
  @Path("/user/{id:Integer}")
  public WOActionResults employeesAction(@PathParam("number") Integer number) {
    NSArray<UserEntry> entries = UserEntry.fetchAllUserEntries(editingContext());
    return response(entries, filter());
  }

}