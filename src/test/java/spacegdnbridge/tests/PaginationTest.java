package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import org.junit.Test;

/**
 * @author boboman13
 */
public class PaginationTest {

	private Bridge bridge;

	public PaginationTest() {
		this.bridge = new Bridge();
		this.bridge.setDebug(true);
	}

	@Test
	public void testPagination() throws Exception {
		APIRequest request = this.bridge.newRequest();
		APIResponse response = request
				.get("builds")
				.page(3)
				.go();

		org.junit.Assert.assertTrue("Should have a true success", response.success);
	}

}
