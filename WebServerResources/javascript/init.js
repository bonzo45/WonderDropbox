function init() {
	fetchUserNames("#userPicker");
	
	/* Display files at server 'root' directory */
	var rootDirectory = new DirectoryCollection();
	var rootDirectoryView = new DirectoryView(rootDirectory);
	rootDirectoryView.setElement("#directory");
	rootDirectory.fetch({
		reset : true
	});
}

function fetchUserNames(dropDown) {
	$(dropDown).html("");
	$.getJSON("DropboxWonder.woa/ra/UserEntry.json", fetchUserNamesCallback(dropDown));
	$(dropDown).change(function() {
		fetchUserFiles(this.value);
	});
}

function fetchUserNamesCallback(dropDown) {
	var dropDownBox = dropDown;
	return function(result) {
		$.each(result, function(i, field) {
			var userName = field.userName;
			var userId = field.id;
			$(dropDownBox).append($('<option/>', {
				value : userId,
				text : userName
			}));
		});
	};
}

function fetchUserFiles(userId) {
	$.getJSON("DropboxWonder.woa/ra/UserEntry/" + userId + ".json", function(result) {
		$("#directory_heading").html("Hi " + result.userName + ", here are your files.");
	});
}