package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import org.junit.Test;

/**
 * @author boboman13
 */
public class BridgeTest {

	@Test
	public void fullTest() throws Exception {
		Bridge bridge = new Bridge();
		bridge.setDebug(true);

		// 1
		APIRequest request = bridge.newRequest();
		APIResponse response = request.get("jars").go();

		org.junit.Assert.assertTrue("Success should be true", response.root.getBoolean("success"));

		// 2
		request = bridge.newRequest();
		response = request.channel(1).get("versions").go();

		org.junit.Assert.assertTrue("Success should be true", response.root.getBoolean("success"));
	}

}
