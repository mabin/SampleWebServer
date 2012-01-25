package org.sws.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestUtil {
	private InputStream input ;
	
	public RequestUtil(InputStream input){
		this.input = input ;
	}
	
	BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
	//StringBuilder sb = new StringBuilder();
	public String requestCode(){
		
		return null ;
	}
}
