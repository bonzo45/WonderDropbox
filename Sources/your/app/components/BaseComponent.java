package your.app.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

import your.app.Application;
import your.app.Session;

public class BaseComponent extends ERXComponent {

  private static final long serialVersionUID = 1L;

  public BaseComponent(WOContext context) {
		super(context);
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
}
