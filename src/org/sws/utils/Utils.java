package org.sws.utils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public interface Utils {
	public  Set<HashMap<String,String>> getConfigs(String confPath);
	public  String requestCode(ByteBuffer requestBuffer);
	public String getPage();
}
