package org.sws.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResponseUtil implements Utils{
	String type ;
	String path ;
	String Protocol ;
	String absPath ;
	
	public ResponseUtil(){}
	
	
	public String getPage(			
			String requestType,
			String requestPath,
			String requestProtocol,
			String filePath){
		
		this.type = requestType ;
		this.path = requestPath.trim() ;
		this.Protocol = requestProtocol ;
		
		FileInputStream fis ;
		StringBuilder sb = new StringBuilder();;
		Scanner scan = null ;
		
		try {
			absPath = new File("").getAbsolutePath();
			fis = new FileInputStream(absPath+filePath+this.path);
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

	@Override
	public void utilInfo() {
		// TODO Auto-generated method stub
		
	}
}
