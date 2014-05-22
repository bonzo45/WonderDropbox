package your.app.rest.controllers;

import your.app.model.FileEntry;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;
import er.extensions.eof.ERXQ;
import er.rest.routes.jsr311.GET;
import er.rest.routes.jsr311.POST;
import er.rest.routes.jsr311.Path;
import er.rest.routes.jsr311.PathParam;

public class FileEntryController extends er.rest.routes.ERXRouteController {

  public FileEntryController(WORequest request) {
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
    filter.include(FileEntry.FILE_NAME);
    
    /* If you supply a key which doesn't exist, throw an error. */
    filter.setUnknownKeyIgnored(false);

    return filter;
  }

  @GET
  @Path("/FileEntry")
  public WOActionResults getAll() {
    NSArray<FileEntry> entries = FileEntry.fetchAllFileEntries(editingContext());
    return response(entries, filter());
  }
  
  @GET
  @Path("/FileEntry/{fileId : Integer}")
  public WOActionResults getOne(@PathParam("fileId") Integer fileId) {
    FileEntry fileEntry = FileEntry.fetchFileEntry(editingContext(), (ERXQ.equals("id", fileId)));
    return response(fileEntry, filter());
  }

  @POST
  @Path("/FileEntry")
  public WOActionResults newOne() {
    FileEntry entry = create("FileEntry", filter());
    editingContext().saveChanges();
    return response(entry, filter());
  }
  
  @Override
  public String entityName() {
    return "FileEntry";
  }
}
