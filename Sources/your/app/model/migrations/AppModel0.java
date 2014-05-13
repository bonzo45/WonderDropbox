package your.app.model.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class AppModel0 extends ERXMigrationDatabase.Migration {
  @Override
  public NSArray<ERXModelVersion> modelDependencies() {
    return null;
  }
  
  @Override
  public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    // DO NOTHING
  }

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable fileEntryTable = database.newTableNamed("FileEntry");
    fileEntryTable.newStringColumn("fileName", 255, false);
    fileEntryTable.newStringColumn("filePath", 255, false);
    fileEntryTable.newIntegerColumn("id", false);
    fileEntryTable.newIntegerColumn("userID", false);
    fileEntryTable.create();
    fileEntryTable.setPrimaryKey("id");

    ERXMigrationTable userEntryTable = database.newTableNamed("UserEntry");
    userEntryTable.newStringColumn("dropboxAccessToken", 255, false);
    userEntryTable.newIntegerColumn("id", false);
    userEntryTable.newStringColumn("userName", 255, false);
    userEntryTable.create();
    userEntryTable.setPrimaryKey("id");

    fileEntryTable.addForeignKey("userID", "UserEntry", "id");
  }
}