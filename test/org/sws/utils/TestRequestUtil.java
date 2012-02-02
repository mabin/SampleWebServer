package org.sws.utils;

import java.io.File;
import java.nio.ByteBuffer;

import org.junit.Test;
import org.sws.utils.ConfigurationUtil;


public class TestRequestUtil {

	@Test
	public void test() {
		String str = "test test test";
		ByteBuffer buffer = ByteBuffer.allocate(2048);
		buffer.put(str.getBytes());
		RequestUtil requestUtil = UtilsFactory.getRequestUtil();
		//String request = requestUtil.requestCode(buffer);
		//System.out.println(request);
	}

}
