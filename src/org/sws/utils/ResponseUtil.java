package org.sws.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResponseUtil extends ABSUtils{
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
		FileInputStream fis ;
		StringBuilder sb = new StringBuilder();;
		Scanner scan = null ;
		
		try {
			fis = new FileInputStream(absPath+this.path);
			scan = new Scanner(fis);
			sb.append("HTTP/1.1 200 OK\r\n");
			sb.append("Content-Type:text/html\r\n\r\n");
			while ( scan.hasNextLine()){
				sb.append(scan.nextLine());
			}
			System.out.println(sb.toString());
			}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sb.toString() ;
	}
}
