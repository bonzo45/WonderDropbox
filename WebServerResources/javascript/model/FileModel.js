 var FileModel = Backbone.Model.extend({
	// URL used to fetch models of this type from the server.
	urlRoot: "DropboxWonder.woa/ra/FileEntry/" + this.id + ".json",
	
	// Default Values
	defaults: {
		name: "",
		path: ""
	}
});