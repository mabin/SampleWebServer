
import org.junit.Test;
import org.sws.utils.ConfigurationUtil;
import org.sws.utils.NICInfos;


public class TestXMLParse {

	@Test
	public void test() {
		ConfigurationUtil util = new ConfigurationUtil();
		util.getConfig();
	}
	
	@Test
	public void testIPs(){
		NICInfos infos = new NICInfos();
		infos.getAllIP();
	}

}
