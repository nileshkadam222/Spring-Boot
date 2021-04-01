package com.sharepoint.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.sharepoint.rest.PLGSharepointClient;
import com.sharepoint.rest.PLGSharepointClientOnline;

public class SharePointTest {


	public static void main(String[] args) throws Exception {
	

		// TODO Auto-generated method stub
		String user = "";
		String passwd = "";
		String domain = "";
		String spSiteUrl = "";

		// get folder List
		PLGSharepointClient wrapper = new PLGSharepointClientOnline(user, passwd, domain, spSiteUrl);
		try {
			JSONObject result = wrapper.getFolderByRelativeUrl("/sites/MRM/Shared Documents/MRM", "{}");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Create New Folder
		// PLGSharepointClient wrapper = new PLGSharepointClient(user, passwd, domain,
		// spSiteUrl);
		try {
			
			JSONObject payload = new JSONObject();
			// payload.put("Title","Document Title set with the API");
			Date date = new Date();
			Timestamp folderName = new Timestamp(date.getTime());
			JSONObject result = wrapper.createFolder("/sites/MRM/Shared Documents/MRM", "test"+folderName.getTime(), payload);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Upload File
		String fileName ="";
		try {
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			fileName = timeStamp.getTime()+".txt";
			MultipartFile multipartFile = new MockMultipartFile(fileName, "Hello World".getBytes());
			// payload is a json object where to place metadata properties to associate with
			// file in this example i set Title
			JSONObject payload = new JSONObject();
			// payload.put("Title","Document Title set with the API");

			JSONObject result = wrapper.uploadFile("/sites/MRM/Shared Documents/MRM", multipartFile.getResource(),
					fileName, payload);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Download file
		try {
			JSONObject payload = new JSONObject();
			Resource result = wrapper.downloadFile("/sites/MRM/Shared Documents/MRM/"+fileName);
			InputStream ins = result.getInputStream();
			try(InputStreamReader r = new InputStreamReader(ins)){
				int data = r.read();
			    while (data != -1) {
			        System.out.print((char) data);
			        data = r.read();
			    }
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//get folders list
		try {
			JSONObject result = wrapper.getFolderFoldersByRelativeUrl("/sites/MRM/Shared Documents/MRM", "{}");
			//System.out.println(result);
			Map<String, Object> map = result.toMap();
			Map<String, Object> d = (Map<String, Object>) map.get("d");
			List<Map<String, Object>> data = (ArrayList<Map<String, Object>>) d.get("results");
			//System.out.println(data.get(0));
			data.stream().forEach(i->{ System.out.println(i.get("Name")); });
			
			String currentFolderName = "test161673682698990";
			boolean checkFolderExist = false;
			for(Map<String,Object> f :data ) {
				String folderName = (String) f.get("Name");
				if(currentFolderName.equalsIgnoreCase(folderName)) {
					checkFolderExist = true;
				}
			}
			System.out.println(checkFolderExist);
			 
			//LOG.debug("Folder list ----> "+result);
			//HashMap<String,Object> readValue = obj.readValue(result.toString(), HashMap.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



