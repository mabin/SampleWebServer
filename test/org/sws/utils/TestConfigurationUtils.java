package org.sws.utils;

import org.junit.Test;
import org.sws.utils.ConfigurationUtil;


public class TestConfigurationUtils {

	@Test
	public void test() {
		ConfigurationUtil util = new ConfigurationUtil();
		util.getConfigs("configuration.xml");
	}

}
