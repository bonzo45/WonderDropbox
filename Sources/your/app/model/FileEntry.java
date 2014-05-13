package your.app.model;

import org.apache.log4j.Logger;

public class FileEntry extends _FileEntry {

  private static final long serialVersionUID = 1L;
  
  @SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(FileEntry.class);
	
	public String fullPath() {
	  return this.filePath() + this.fileName();
	}
}
