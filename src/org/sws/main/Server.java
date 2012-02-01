package org.sws.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


import org.sws.utils.ConfigurationUtil;
import org.sws.utils.Utils;
import org.sws.utils.UtilsFactory;


public class Server {
	public String serverName;
	public String serverPort;
	public String serverPath;
	public String serverAddress;
	private Set<HashMap<String,String>> configSet;
	
	public Server(){
		Utils configUtil = UtilsFactory.newInstance("org.sws.utils.ConfigurationUtil");
		configSet =configUtil.getConfigs("configuration.xml");
		initServer(configSet);
	}
	
	public void initServer(Set<HashMap<String,String>> configSet){

		Iterator<HashMap<String,String>> configIter = configSet.iterator();
		while(configIter.hasNext()){
			HashMap<String,String> configMap = (HashMap<String,String>)configIter.next();

			serverName = configMap.get("name");
			serverPort = configMap.get("port");
			serverPath = configMap.get("path");
			serverAddress = configMap.get("address");
			System.out.println("Start run "+serverName+" [port:"+serverPort+",path:"+serverPath+",address:"+serverAddress+"]");
			
			Handler handler = new Handler(configSet);
			handler.run();
		}

	}
}
