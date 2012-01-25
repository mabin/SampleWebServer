package org.sws.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String sourceIp ;
	private String browser ;
	private List<String> request = new ArrayList<String>();
	public Client(String sourceIp, String browser, List<String> request) {
		super();
		this.sourceIp = sourceIp;
		this.browser = browser;
		this.request = request;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public List<String> getRequest() {
		return request;
	}
	public void setRequest(List<String> request) {
		this.request = request;
	}
	@Override
	public String toString() {
		return "Client [sourceIp=" + sourceIp + ", browser=" + browser
				+ ", request=" + request + "]";
	}
	
}
