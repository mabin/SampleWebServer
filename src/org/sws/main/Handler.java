package org.sws.main;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.sws.utils.RequestUtil;
import org.sws.utils.Utils;
import org.sws.utils.UtilsFactory;

public class Handler {
	public String serverName;
	public String serverPort;
	public String serverPath;
	public String serverAddress;
	public Set<HashMap<String,String>> configSet;
	public Iterator<HashMap<String,String>> configIter;
	public HashMap<String,String> configMap ;
	
	public Handler(Set<HashMap<String,String>> configSet){
		this.configSet = configSet;
		configIter = configSet.iterator();
		this.run();
	}
	
	public void run() {
		try {
			//端口与HTML文件夹对应的Map
			HashMap<Integer,String> portMap = new HashMap<Integer,String>();
			Selector selector = Selector.open();
			while (configIter.hasNext()){
				configMap = (HashMap<String,String>)configIter.next();
				ServerSocketChannel serverChannel = ServerSocketChannel.open();
				serverChannel.configureBlocking(false);
				InetSocketAddress address = new InetSocketAddress(Integer.parseInt(configMap.get("port")));
				serverChannel.bind(address);
				
				SelectionKey selectionKey = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
				System.out.println("开始启动"+configMap.get("name")+"服务器,监听的端口是"+configMap.get("port"));
				portMap.put(Integer.parseInt(configMap.get("port")), configMap.get("path"));
				System.out.println("port --> "+configMap.get("port"));
				System.out.println("path --> "+configMap.get("path"));
			}

			boolean status = true;
			while (status){
				int num = selector.select();//选择了多少个请求
				
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keysIter = selectedKeys.iterator();
				
				while (keysIter.hasNext()){
					SelectionKey selectedKey = (SelectionKey)keysIter.next();
					
					//如果已选择通道为新建连接请求
					if ((selectedKey.readyOps()&SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
						ServerSocketChannel servChannel = (ServerSocketChannel)selectedKey.channel();
						SocketChannel socketChannel = servChannel.accept();
						socketChannel.configureBlocking(false);
						
						//添加一个新key，将通道操作导向读取request
						SelectionKey requestKey = socketChannel.register(selector, SelectionKey.OP_READ);
						keysIter.remove();
						
						System.out.println("得到一个新的连接："+socketChannel);
					}
					//如果已选择通道为读取数据请求
					else if ( (selectedKey.readyOps()&SelectionKey.OP_READ) == SelectionKey.OP_READ){
						SocketChannel socketChannel = (SocketChannel)selectedKey.channel();
						//通过通道端口号获取对应文档路径

						String filePath = portMap.get(socketChannel.socket().getLocalPort());
						ByteBuffer httpBuffer = ByteBuffer.allocate(2048);
						httpBuffer.clear();
						int i = socketChannel.read(httpBuffer);
						if (i >= 0){
							RequestUtil requestUtil = UtilsFactory.getRequestUtil();
							
							String request = requestUtil.requestCode(httpBuffer,File.separator+filePath);
							
							ByteBuffer responseBuffer = Charset.forName("gb2312").encode(request);
							
							socketChannel.write(responseBuffer);
							socketChannel.close();
							httpBuffer.clear();
							responseBuffer.clear();
							//System.out.println("buffer clear after "+new String(httpBuffer.array()));
						}
					}
					//如果以选择通道为写入数据请求
					else if ( (selectedKey.readyOps()&SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE){
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



































