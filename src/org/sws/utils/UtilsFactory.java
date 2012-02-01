package org.sws.utils;

public class UtilsFactory {
	public static Utils newInstance(String className){
		Object obj = null ;
		try {
			obj = Class.forName(className).newInstance();
			//System.out.print(obj.getClass().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (obj.getClass().getName().equals("org.sws.utils.ConfigurationUtil")){
			return (ConfigurationUtil)obj;
		}
		else if (obj.getClass().getName().equals("org.sws.utils.RequestUtil")){
			return (RequestUtil)obj;
		}
		else if (obj.getClass().getName().equals("org.sws.utils.ResponseUtil")){
			return (ResponseUtil)obj;
		}
		else
		{
			return null;
		}
	}
}
