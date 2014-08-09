package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import org.junit.Test;

/**
 * @author boboman13
 */
public class BasicSingleReturnsTest {

	private Bridge bridge;

	public BasicSingleReturnsTest() {
		this.bridge = new Bridge();
		this.bridge.setDebug(true);
	}

	@Test
	public void basicGetJarTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.jar(2)
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		org.junit.Assert.assertEquals("Description should be correct", response.jar.description, "CraftBukkit is The Minecraft Server Mod API Implementation.");
	}

	@Test
	public void basicGetVersionTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.version(19)
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		org.junit.Assert.assertEquals("Version should be correct", response.version.version, "1.2.5-R1.2");
	}

	@Test
	public void basicGetBuildTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.build(173)
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		org.junit.Assert.assertEquals("URL should be correct", response.build.url, "http://ci.md-5.net/job/MCPC-Plus/20/artifact/build/distributions/mcpc-plus-1.7.2-R0.3-forge1022-B20.jar");
	}

	@Test
	public void basicGetChannelTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request
				.channel(3)
				.go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
		org.junit.Assert.assertEquals("Name should be correct", response.channel.name, "beta");
	}

}
