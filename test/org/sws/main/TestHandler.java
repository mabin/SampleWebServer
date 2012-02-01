package org.sws.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.sws.utils.ConfigurationUtil;
import org.sws.utils.Utils;
import org.sws.utils.UtilsFactory;

public class TestHandler {

	@Test
	public void test() {
		Utils configUtil = UtilsFactory.newInstance("org.sws.utils.ConfigurationUtil");
		Set<HashMap<String, String>> configSet = configUtil.getConfigs("configuration.xml");

		Iterator<HashMap<String, String>> configIter = configSet.iterator();
		while (configIter.hasNext()) {
			int i=0 ;
			//HashMap<String, String> configMap = (HashMap<String, String>) configIter.next();

			Handler handler = new Handler(configSet);
			handler.run();
		}

	}
}
