package org.sws.utils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public abstract class ABSUtils implements Utils{
	public  Set<HashMap<String,String>> getConfigs(String confPath){
		return null;
	}
	public  String requestCode(ByteBuffer requestBuffer){
		return null;
	};
	public 	String getPage(){
		return null;
	};
}
