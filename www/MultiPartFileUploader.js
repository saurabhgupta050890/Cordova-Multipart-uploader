var blobuploder = {
	uploadFile : function(filePath, uploadUrl,successCallback,errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'MultiPartFileUploader',
			'MultipartFileUpload',
			[{
				"blobUrl":uploadUrl,
				"filePath":filePath
			}]
		);
	}
}

module.exports = blobuploder;