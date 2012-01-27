package org.sws.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResponseUtil {
	String type ;
	String path ;
	String Protocol ;
	String absPath = "/home/benjamin/workspace/SampleWebServer";
	
	public ResponseUtil(
			String requestType,
			String requestPath,
			String requestProtocol){
		this.type = requestType ;
		this.path = requestPath.trim() ;
		this.Protocol = requestProtocol ;		
	}
	
	public String getPage(){
		try {
			FileInputStream fis = new FileInputStream(absPath+this.path);
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(fis));
			StringBuilder sb = new StringBuilder();
			String line="";
			while ( (line=buffer.readLine()) != null){
				sb.append(line);
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}
