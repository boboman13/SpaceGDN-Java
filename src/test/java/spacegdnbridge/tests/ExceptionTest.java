package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import net.boboman13.spacegdnbridge.response.BridgeException;
import org.junit.Test;

/**
 * Tests specifically for the throwing of exceptions.
 * @author
 */
public class ExceptionTest {

	private Bridge bridge;

	public ExceptionTest() {
		this.bridge = new Bridge();
		this.bridge.setDebug(true);
	}

	@Test
	public void testNoSegments() {
		boolean didFail = false;

		APIRequest request = this.bridge.newRequest();

		try {
			APIResponse response = request.go();
		} catch (BridgeException ex) {
			didFail = true;
		}

		org.junit.Assert.assertTrue("BridgeException should have been thrown", didFail);
	}

}
