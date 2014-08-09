package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import org.junit.Test;

/**
 * @author boboman13
 */
public class BridgeTest {

	@Test
	public void constructionTest() {
		Bridge bridge = new Bridge();
		bridge.setDebug(true);

		APIRequest request = bridge.newRequest();
	}

	@Test
	public void customHostConstructionTest() {
		// Note: this isn't actually a GDN host.
		Bridge bridge = new Bridge("http://gdnhost.fakeapi.boboman13.net");
		bridge.setDebug(true);

		APIRequest request = bridge.newRequest();
	}

}
