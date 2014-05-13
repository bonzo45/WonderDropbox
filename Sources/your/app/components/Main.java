package your.app.components;

import com.webobjects.appserver.WOContext;

public class Main extends BaseComponent {

  private static final long serialVersionUID = 1L;

  private String myTextForDisplay = "Hello World from the Java world";
  
  public String myTextForDisplay() {
    return myTextForDisplay;
  }
   
  public void setMyTextForDisplay(String myTextForDisplay) {
    this.myTextForDisplay = myTextForDisplay;
  }
  
  public Main(WOContext context) {
		super(context);
	}
}
