package com.metacube.metacampus.multipartfileuploader;

import java.io.File;
import java.util.List;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPartFileUploader extends CordovaPlugin{

	public final static String MULTIPART_FILE_UPLOAD_ACTION = "MultipartFileUpload";

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		// TODO Auto-generated method stub

		try {
			if (MULTIPART_FILE_UPLOAD_ACTION.equals(action)) {
				final JSONObject arg_object = args.getJSONObject(0);
				final String blobUrl = arg_object.getString("blobUrl");
				final String filePath = arg_object.getString("filePath");
				
				//final String fileUriString = arg_object.getString("uri");
				//Uri fileUri = Uri.parse(fileUriString);
				//File file = new File(fileUri);

				File file = new File(filePath);

				System.out.println("File found:" + file.getName() + ":" + file.length());

				if(file.isFile()) {
					MultipartUtility multipart = new MultipartUtility(blobUrl, "UTF-8");
					multipart.addFilePart(file.getName(), file);
					List<String> response = multipart.finish();
					StringBuffer result = new StringBuffer();
					System.out.println("File Upload Response:");
					for (String line : response) {
						System.out.println(line);
						result.append(line);
					}

					System.out.println(result);
					callbackContext.success(new String(result));
					return true;
				} else {
					System.out.println("File Found was:" + file.toString());
					callbackContext.error("File not found");
					return false;
				}

			}
			return false;
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			callbackContext.error(e.getMessage());
			return false;
		}

	}

}
