// DO NOT EDIT.  Make changes to UserEntry.java instead.
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
public abstract class _UserEntry extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "UserEntry";

  // Attribute Keys
  public static final ERXKey<String> DROPBOX_ACCESS_TOKEN = new ERXKey<String>("dropboxAccessToken");
  public static final ERXKey<String> USER_NAME = new ERXKey<String>("userName");
  // Relationship Keys

  // Attributes
  public static final String DROPBOX_ACCESS_TOKEN_KEY = DROPBOX_ACCESS_TOKEN.key();
  public static final String USER_NAME_KEY = USER_NAME.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_UserEntry.class);

  public UserEntry localInstanceIn(EOEditingContext editingContext) {
    UserEntry localInstance = (UserEntry)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String dropboxAccessToken() {
    return (String) storedValueForKey(_UserEntry.DROPBOX_ACCESS_TOKEN_KEY);
  }

  public void setDropboxAccessToken(String value) {
    if (_UserEntry.LOG.isDebugEnabled()) {
    	_UserEntry.LOG.debug( "updating dropboxAccessToken from " + dropboxAccessToken() + " to " + value);
    }
    takeStoredValueForKey(value, _UserEntry.DROPBOX_ACCESS_TOKEN_KEY);
  }

  public String userName() {
    return (String) storedValueForKey(_UserEntry.USER_NAME_KEY);
  }

  public void setUserName(String value) {
    if (_UserEntry.LOG.isDebugEnabled()) {
    	_UserEntry.LOG.debug( "updating userName from " + userName() + " to " + value);
    }
    takeStoredValueForKey(value, _UserEntry.USER_NAME_KEY);
  }


  public static UserEntry createUserEntry(EOEditingContext editingContext, String dropboxAccessToken
, String userName
) {
    UserEntry eo = (UserEntry) EOUtilities.createAndInsertInstance(editingContext, _UserEntry.ENTITY_NAME);    
		eo.setDropboxAccessToken(dropboxAccessToken);
		eo.setUserName(userName);
    return eo;
  }

  public static ERXFetchSpecification<UserEntry> fetchSpec() {
    return new ERXFetchSpecification<UserEntry>(_UserEntry.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<UserEntry> fetchAllUserEntries(EOEditingContext editingContext) {
    return _UserEntry.fetchAllUserEntries(editingContext, null);
  }

  public static NSArray<UserEntry> fetchAllUserEntries(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _UserEntry.fetchUserEntries(editingContext, null, sortOrderings);
  }

  public static NSArray<UserEntry> fetchUserEntries(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<UserEntry> fetchSpec = new ERXFetchSpecification<UserEntry>(_UserEntry.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<UserEntry> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static UserEntry fetchUserEntry(EOEditingContext editingContext, String keyName, Object value) {
    return _UserEntry.fetchUserEntry(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static UserEntry fetchUserEntry(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<UserEntry> eoObjects = _UserEntry.fetchUserEntries(editingContext, qualifier, null);
    UserEntry eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one UserEntry that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static UserEntry fetchRequiredUserEntry(EOEditingContext editingContext, String keyName, Object value) {
    return _UserEntry.fetchRequiredUserEntry(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static UserEntry fetchRequiredUserEntry(EOEditingContext editingContext, EOQualifier qualifier) {
    UserEntry eoObject = _UserEntry.fetchUserEntry(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no UserEntry that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static UserEntry localInstanceIn(EOEditingContext editingContext, UserEntry eo) {
    UserEntry localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
