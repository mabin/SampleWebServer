package org.sws.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RequestUtil implements Utils {

	public RequestUtil(){}

	public String requestCode(ByteBuffer requestBuffer,String filePath){
		String pageContent = "";
		String str = new String(requestBuffer.array());
		//System.out.println(str);
		System.out.println("=======================");
		String[] lines = str.split("\r\n");
		for (int i=0; i<lines.length; i++){
			System.out.println(lines[i]);
		}
		//System.out.println(lines.length);
		Map<String,String> requestMap = new HashMap<String,String>();

		for (int i=0; i<lines.length-2; i++){
			if ( i==0 ){
				String[] line = lines[i].split(" ");
				requestMap.put("requestType", line[0].trim());
				requestMap.put("requestPath", line[1].trim());
				requestMap.put("requestProtocol", line[2].trim());
				System.out.println(i+" is work");
				continue;
			} 				
			
			String[] line = lines[i].split(":");
			requestMap.put(line[0].trim(),line[1].trim());
		}
		
		Iterator<Entry<String, String>> iter = requestMap.entrySet().iterator();
		while (iter.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
			//System.out.print( entry.getKey()+" = ");
		//	System.out.println( entry.getValue());
		
		}
		
		ResponseUtil rep = UtilsFactory.getResponseUtil();
		pageContent = rep.getPage(				
				requestMap.get("requestType"),
				requestMap.get("requestPath"),
				requestMap.get("requestProtocol"),
				filePath); 
				
		return pageContent ;
	}
	@Override
	public void utilInfo() {
		// TODO Auto-generated method stub
		
	}
}
