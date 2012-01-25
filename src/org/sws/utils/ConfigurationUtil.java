package org.sws.utils;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.sws.model.Server;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigurationUtil {
	private String conf = "configuration.xml";
	// Document是XML在内存中的一个镜像，获取了Document就可以通过对内存的操作来实现对XML的操作。
	private Document doc = null;

	public Server getConfig() {
		Server server = new Server();
		int port;
		String service = "";
		String protocol;
		// Set<String> hosts = new HashSet<String>();
		String root;
		Map<String, String> valueMap = new HashMap<String, String>();

		// 从DocumentBuilderFactory中获取一个DocumentBuilder的实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 使用DocumentBuilder来产生一个Document实例
			doc = db.parse(new File(conf));

			// Element代表XML中的一个标签对，可用于获取属性值
			Element element = doc.getDocumentElement();
			// 获取该Element的标签名
			System.out.println("Root Element : " + element.getTagName());
			// 通过标签名来获取多个节点
			NodeList nodeList = doc.getElementsByTagName("Service");
			System.out.println("NodeList Length : " + nodeList.getLength());

			Node node = nodeList.item(0);
			System.out.println("First Node : " + node.getNodeName());
			// 通过Atttributes（）方法来获取一个NamedNodeMap实例，该实例包含标签属性值
			NamedNodeMap attrs = node.getAttributes();

			for (int i = 0; i < attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				System.out.println(attr.getNodeName() + " : "
						+ attr.getNodeValue());
				service = attr.getNodeValue();
			}

			NodeList childNodes = node.getChildNodes();

			for (int i = 0; i < childNodes.getLength(); i++) {
				Node child = childNodes.item(i);
				// 当子节点是一个Element时才能获取该元素的标签名和属性值
				if (child instanceof Element) {
					System.out.println(i);
					System.out.println(child.getNodeName() + " : "
							+ child.getFirstChild().getNodeValue());
					valueMap.put(child.getNodeName(), child.getFirstChild()
							.getNodeValue());
				}
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

		port = Integer.parseInt(valueMap.get("Listen"));
		protocol = valueMap.get("Protocol");
		root = valueMap.get("Root");

		server.getListen().addAll(NICInfos.getAllIP());
		server.setPort(port);
		server.setProtocol(protocol);
		server.setRoot(root);
		server.setService(service);

		System.out.println(server);
		return server;
	}

}
