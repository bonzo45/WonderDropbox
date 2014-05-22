// DO NOT EDIT.  Make changes to FileEntry.java instead.
package your.app.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _FileEntry extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "FileEntry";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_TIME = new ERXKey<NSTimestamp>("creationTime");
  public static final ERXKey<String> FILE_NAME = new ERXKey<String>("fileName");
  public static final ERXKey<String> FILE_PATH = new ERXKey<String>("filePath");
  public static final ERXKey<Boolean> IS_DIRECTORY = new ERXKey<Boolean>("isDirectory");
  public static final ERXKey<NSTimestamp> MODIFIED_TIME = new ERXKey<NSTimestamp>("modifiedTime");
  public static final ERXKey<Long> SIZE = new ERXKey<Long>("size");
  // Relationship Keys

  // Attributes
  public static final String CREATION_TIME_KEY = CREATION_TIME.key();
  public static final String FILE_NAME_KEY = FILE_NAME.key();
  public static final String FILE_PATH_KEY = FILE_PATH.key();
  public static final String IS_DIRECTORY_KEY = IS_DIRECTORY.key();
  public static final String MODIFIED_TIME_KEY = MODIFIED_TIME.key();
  public static final String SIZE_KEY = SIZE.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_FileEntry.class);

  public FileEntry localInstanceIn(EOEditingContext editingContext) {
    FileEntry localInstance = (FileEntry)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationTime() {
    return (NSTimestamp) storedValueForKey(_FileEntry.CREATION_TIME_KEY);
  }

  public void setCreationTime(NSTimestamp value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating creationTime from " + creationTime() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.CREATION_TIME_KEY);
  }

  public String fileName() {
    return (String) storedValueForKey(_FileEntry.FILE_NAME_KEY);
  }

  public void setFileName(String value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating fileName from " + fileName() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.FILE_NAME_KEY);
  }

  public String filePath() {
    return (String) storedValueForKey(_FileEntry.FILE_PATH_KEY);
  }

  public void setFilePath(String value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating filePath from " + filePath() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.FILE_PATH_KEY);
  }

  public Boolean isDirectory() {
    return (Boolean) storedValueForKey(_FileEntry.IS_DIRECTORY_KEY);
  }

  public void setIsDirectory(Boolean value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating isDirectory from " + isDirectory() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.IS_DIRECTORY_KEY);
  }

  public NSTimestamp modifiedTime() {
    return (NSTimestamp) storedValueForKey(_FileEntry.MODIFIED_TIME_KEY);
  }

  public void setModifiedTime(NSTimestamp value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating modifiedTime from " + modifiedTime() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.MODIFIED_TIME_KEY);
  }

  public Long size() {
    return (Long) storedValueForKey(_FileEntry.SIZE_KEY);
  }

  public void setSize(Long value) {
    if (_FileEntry.LOG.isDebugEnabled()) {
    	_FileEntry.LOG.debug( "updating size from " + size() + " to " + value);
    }
    takeStoredValueForKey(value, _FileEntry.SIZE_KEY);
  }


  public static FileEntry createFileEntry(EOEditingContext editingContext, NSTimestamp creationTime
, String fileName
, String filePath
, Boolean isDirectory
, NSTimestamp modifiedTime
, Long size
) {
    FileEntry eo = (FileEntry) EOUtilities.createAndInsertInstance(editingContext, _FileEntry.ENTITY_NAME);    
		eo.setCreationTime(creationTime);
		eo.setFileName(fileName);
		eo.setFilePath(filePath);
		eo.setIsDirectory(isDirectory);
		eo.setModifiedTime(modifiedTime);
		eo.setSize(size);
    return eo;
  }

  public static ERXFetchSpecification<FileEntry> fetchSpec() {
    return new ERXFetchSpecification<FileEntry>(_FileEntry.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<FileEntry> fetchAllFileEntries(EOEditingContext editingContext) {
    return _FileEntry.fetchAllFileEntries(editingContext, null);
  }

  public static NSArray<FileEntry> fetchAllFileEntries(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _FileEntry.fetchFileEntries(editingContext, null, sortOrderings);
  }

  public static NSArray<FileEntry> fetchFileEntries(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<FileEntry> fetchSpec = new ERXFetchSpecification<FileEntry>(_FileEntry.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<FileEntry> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static FileEntry fetchFileEntry(EOEditingContext editingContext, String keyName, Object value) {
    return _FileEntry.fetchFileEntry(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FileEntry fetchFileEntry(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<FileEntry> eoObjects = _FileEntry.fetchFileEntries(editingContext, qualifier, null);
    FileEntry eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one FileEntry that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FileEntry fetchRequiredFileEntry(EOEditingContext editingContext, String keyName, Object value) {
    return _FileEntry.fetchRequiredFileEntry(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static FileEntry fetchRequiredFileEntry(EOEditingContext editingContext, EOQualifier qualifier) {
    FileEntry eoObject = _FileEntry.fetchFileEntry(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no FileEntry that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FileEntry localInstanceIn(EOEditingContext editingContext, FileEntry eo) {
    FileEntry localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
