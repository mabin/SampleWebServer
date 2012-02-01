package org.sws.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RequestUtil extends ABSUtils {
	public static InputStream input ;

	public RequestUtil(){}
	public RequestUtil(InputStream input){
		this.input = input ;
		//requestCode();
	}

	public String requestCode(ByteBuffer requestBuffer){
		String pageContent = "";
		try {
			byte[] buffer = new byte[2048];
			input.read(buffer);
			String str = new String(buffer);
			System.out.println(str);
			System.out.println("=======================");
			String[] lines = str.split("\r\n");
			System.out.println(lines.length);
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
				
				System.out.println(i+" is work");
				String[] line = lines[i].split(":");
				requestMap.put(line[0].trim(),line[1].trim());
			}
			
			Iterator<Entry<String, String>> iter = requestMap.entrySet().iterator();
			while (iter.hasNext()){
				Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
				System.out.print( entry.getKey()+" = ");
				System.out.println( entry.getValue());
			
			}
			
			ResponseUtil rep = new ResponseUtil(
					requestMap.get("requestType"),
					requestMap.get("requestPath"),
					requestMap.get("requestProtocol"));
			pageContent = rep.getPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return pageContent ;
	}
}
