Cordova-Multipart-uploader
==========================

## Description ##

This is a `Cordova plugin` to upload a file from an Android device to server in form of multi-part form data. Many server applications like `Google App Engine Blobstore` requires a `multipart/formdata` requests to upload a file. This plugin picks a file from the device and creates a `multipart/formdata` request with the file as attachment. 

## Installation ##

Install using **Cordoda CLI**:

  

>  $  cordova plugin add https://github.com/saurabhgupta050890/Cordova-Multipart-uploader.git

   
 **Install using Plugman:** 
 
   

> $ plugman --platform android --project /path/to/project --plugin https://github.com/saurabhgupta050890/Cordova-Multipart-uploader.git 


## Usage ##

This plugin takes two arguments 
    
    

> filepath: Local Path of the file on device to be uploaded.
Upload Url: Full URL of the server where to upload the file.

    var onSuccess = function(result) {
        //Gets the server response object in the form of a string.
        var serverResponse = JSON.parse(result);
    }
    
    var onFailure = function(errorMsg) {
        console.log("Upload failed:" + errorMsg);
    }
    
    window.fileUpload.uploadFile(filePath,uploadUrl,onSuccess,onFailure);
    
    
    

## Future Milestones ##

Make it more generic to create multipart requests with multiple files and additional fields. 
