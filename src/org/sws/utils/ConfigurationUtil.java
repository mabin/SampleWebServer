package org.sws.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public  class ConfigurationUtil extends ABSUtils{

	public  Document document = null;
	public  Set<HashMap<String,String>> configSet = new HashSet<HashMap<String,String>>();

	public  Set<HashMap<String,String>> getConfigs(String confPath){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(new File(confPath));
			
			//获取host标签列表
			NodeList nodeList = document.getElementsByTagName("Host");
			//System.out.println("NodeList by Host length is: "+nodeList.getLength());
			for (int i=0; i<nodeList.getLength(); i++){
				HashMap<String,String> configMap = new HashMap<String,String>();
				Node node = nodeList.item(i);
				//System.out.println(node.getNodeName());
				NamedNodeMap attrs = node.getAttributes();
				
				for (int k=0; k<attrs.getLength(); k++){
					Node attr = attrs.item(k);
					//System.out.println(i+" "+attr.getNodeName()+" "+attr.getNodeValue());
					configMap.put(attr.getNodeName(), attr.getNodeValue());
				}
				configSet.add(configMap);
				//System.out.println(configSet.isEmpty());
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return configSet;
	}
}
