package org.sws.utils;

public class UtilsFactory {
	public static Object obj = null ;

	public static ConfigurationUtil getConfigUtil(){
		try {
			obj = Class.forName("org.sws.utils.ConfigurationUtil").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ConfigurationUtil)obj;
	}
	
	public static RequestUtil getRequestUtil(){
		try {
			obj = Class.forName("org.sws.utils.RequestUtil").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (RequestUtil)obj;
	}
	public static ResponseUtil getResponseUtil(){
		try {
			obj = Class.forName("org.sws.utils.ResponseUtil").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ResponseUtil)obj;
	}
}
