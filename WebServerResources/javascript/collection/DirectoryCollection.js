var DirectoryCollection = Backbone.Collection.extend({
	// URL to pull from server
	url : "DropboxWonder.woa/ra/FileEntry.json",

	model : FileModel,
	
	// How to extract the list of files from the returned JSON.
	parse: function(response){ 
        return response.files; 
    }
});