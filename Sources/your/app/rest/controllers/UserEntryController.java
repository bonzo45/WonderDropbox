package your.app.rest.controllers;

import your.app.model.UserEntry;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;
import er.rest.routes.ERXDefaultRouteController;

public class UserEntryController extends ERXDefaultRouteController {

  public UserEntryController(WORequest request) {
    super(request);
  }

  protected ERXKeyFilter filter() {
    ERXKeyFilter myFilter = ERXKeyFilter.filterWithAttributes();
    myFilter.setAnonymousUpdateEnabled(true);

    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    filter.include(UserEntry.USER_NAME, myFilter);
    filter.setUnknownKeyIgnored(true);

    return filter;
  }

  @Override
  public WOActionResults newAction() throws Throwable {
    return null;
  }

  @Override
  public WOActionResults updateAction() throws Throwable {
    return null;
  }

  @Override
  public WOActionResults destroyAction() throws Throwable {
    return null;
  }

  @Override
  public WOActionResults showAction() throws Throwable {
    return null;
  }

  @Override
  public WOActionResults createAction() throws Throwable {
    UserEntry entry = create(filter());
    editingContext().saveChanges();
    return response(entry, filter());
  }

  @Override
  public WOActionResults indexAction() throws Throwable {
    NSArray<UserEntry> entries = UserEntry.fetchAllUserEntries(editingContext());
    return response(entries, filter());
  }

}
