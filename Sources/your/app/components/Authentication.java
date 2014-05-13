package your.app.components;

import your.app.model.UserEntry;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSArray;

public class Authentication extends BaseComponent {
    public Authentication(WOContext context) {
        super(context);
    }
    
    public NSArray<String> getUserNameList() {
      UserEntry.fetchAllUserEntries(editingContext);
    }
}