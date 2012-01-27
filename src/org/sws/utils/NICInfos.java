package org.sws.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public final class NICInfos {
	public static Enumeration<NetworkInterface> nics = null ;
	
	public static Set<String> getAllIP()
	{
		Set<String> ips = new HashSet<String>();
		try {
			nics = NetworkInterface.getNetworkInterfaces();
			
			while ( nics.hasMoreElements() ){
				NetworkInterface nic = nics.nextElement();
			//	System.out.println(nic.getDisplayName());
				
				Enumeration<InetAddress> adrs = nic.getInetAddresses();
				
				while(adrs.hasMoreElements()){
					String ip = adrs.nextElement().getHostAddress();
			//		System.out.println(ip);
					ips.add(ip);
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ips ;
	}
}
