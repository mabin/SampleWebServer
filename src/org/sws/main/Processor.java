package org.sws.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.sws.model.Server;
import org.sws.utils.ConfigurationUtil;
import org.sws.utils.RequestUtil;
import org.sws.utils.ResponseUtil;

public class Processor {
	ServerSocket serverSocket = null ;
	Socket clientSocket = null ;
	InputStream input = null ;
	OutputStream output = null ;
	Server serverInfo ;
	RequestUtil request = null ;
	ResponseUtil response = null ;
	
	public void run(){
		try {
			serverInfo = new ConfigurationUtil().getConfig();
			serverSocket = new ServerSocket(serverInfo.getPort());
			clientSocket = serverSocket.accept();
			input = clientSocket.getInputStream();
			request = new RequestUtil(input);
			String str = request.requestCode();
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
			writer.write(str);
			writer.flush();
			clientSocket.close();
			serverSocket.close();
			System.out.println("end all");
			//response = new ResponseUtil();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
