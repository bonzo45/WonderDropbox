package your.app.rest.controllers;

import your.app.model.FileEntry;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;

public class FileEntryController extends er.rest.routes.ERXDefaultRouteController {

  public FileEntryController(WORequest request) {
    super(request);
  }

  protected ERXKeyFilter filter() {
    ERXKeyFilter myFilter = ERXKeyFilter.filterWithAttributes();
    myFilter.setAnonymousUpdateEnabled(true);

    ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
    filter.include(FileEntry.FILE_NAME, myFilter);
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
    FileEntry entry = create(filter());
    editingContext().saveChanges();
    return response(entry, filter());
  }

  @Override
  public WOActionResults indexAction() throws Throwable {
    NSArray<FileEntry> entries = FileEntry.fetchAllFileEntries(editingContext());
    return response(entries, filter());
  }
}
