package org.sws.model;

import java.util.HashSet;
import java.util.Set;

public class Server {
	private int port ;
	private String service ;
	private String root ;
	private Set<String> listen = new HashSet<String>();
	private String protocol ;
	public Server(){
		
	}
	public Server(int port, String service, String root, Set<String> listen,
			String protocol) {
		super();
		this.port = port;
		this.service = service;
		this.root = root;
		this.listen = listen;
		this.protocol = protocol;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public Set<String> getListen() {
		return listen;
	}
	public void setListen(Set<String> listen) {
		this.listen = listen;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	@Override
	public String toString() {
		return "Server [port=" + port + ", service=" + service + ", root="
				+ root + ", listen=" + listen + ", protocol=" + protocol + "]";
	}
	
}
