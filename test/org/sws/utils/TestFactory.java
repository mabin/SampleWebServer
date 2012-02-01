package org.sws.utils;

import org.junit.Test;
import org.sws.utils.ConfigurationUtil;


public class TestFactory {

	@Test
	public void test() {
		UtilsFactory u = new UtilsFactory();
		u.newInstance("org.sws.utils.RequestUtil");
		//RequestUtil util = (RequestUtil)UtilsFactory.newInstance("RequestUtil");
	}

}
