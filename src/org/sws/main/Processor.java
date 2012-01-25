package org.sws.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.sws.model.Server;
import org.sws.utils.RequestUtil;
import org.sws.utils.ResponseUtil;

public class Processor {
	ServerSocket serverSocket = null ;
	Socket clientSocket = null ;
	InputStream input = null ;
	OutputStream output = null ;
	Server serverInfo = new Server();
	RequestUtil request = null ;
	ResponseUtil response = null ;
	
	public void run(){
		try {
			serverSocket = new ServerSocket(serverInfo.getPort());
			clientSocket = serverSocket.accept();
			input = clientSocket.getInputStream();
			request = new RequestUtil();
			response = new ResponseUtil();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
