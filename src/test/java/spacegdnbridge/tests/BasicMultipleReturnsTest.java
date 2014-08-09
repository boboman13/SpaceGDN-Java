package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import org.junit.Test;

/**
 * Please note that for tests, arrays in Java are ZERO-BASED.
 * @author boboman13
 */
public class BasicMultipleReturnsTest {

	private Bridge bridge;

	public BasicMultipleReturnsTest() {
		this.bridge = new Bridge();
		this.bridge.setDebug(true);
	}

	@Test
	public void basicGetJarsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.get("jars")
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		//org.junit.Assert.assertEquals("Jar id[3] should have correct site URL", response.jars[2].site_url, "http://ci.md-5.net/job/MCPC-Plus/");
	}

	@Test
	public void basicGetVersionsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.get("versions")
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		//org.junit.Assert.assertEquals("Version id[2] should have correct created_at date", response.versions[1].created_at, "Sat, 31 May 2014 12:00:05 GMT");
	}

	@Test
	public void basicGetBuildsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.get("builds")
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		//org.junit.Assert.assertEquals("Build id[6] should have correct updated_at date", response.builds[5].updated_at, "Sun, 16 Mar 2014 17:41:25 GMT");
	}

	@Test
	public void basicGetChannelsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.get("channels")
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		//org.junit.Assert.assertEquals("Channel id[6] should have correct jar_id", response.channels[5].jar_id, 4);
	}

}
