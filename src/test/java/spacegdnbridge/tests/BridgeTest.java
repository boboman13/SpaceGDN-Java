package spacegdnbridge.tests;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.request.APIRequest;
import net.boboman13.spacegdnbridge.response.APIResponse;
import org.junit.Test;

/**
 * @author boboman13
 */
public class BridgeTest {

	private Bridge bridge;

	public BridgeTest() {
		this.bridge = new Bridge();
		this.bridge.setDebug(true);
	}

	@Test
	public void basicGetJarsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request.get("jars").go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
	}

	@Test
	public void basicGetVersionsTest() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request.get("versions").go();

		org.junit.Assert.assertTrue("Success should be true", response.success);
	}

	@Test
	public void specificTestForChannelVersionDate() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request.channel(1).version(156).go();

		org.junit.Assert.assertEquals("Should give right created_at date", "Fri, 30 May 2014 18:00:05 GMT", response.version.created_at);
	}

	@Test
	public void specificTestForJarChannelVersionBuildUrl() throws Exception {
		APIRequest request = bridge.newRequest();
		APIResponse response = request.jar(6).channel(11).version(105).build(482).go();

		org.junit.Assert.assertEquals("Should give right URL", "https://s3.amazonaws.com/Minecraft.Download/versions/a1.0.17_04/minecraft_server.a1.0.17_04.jar", response.build.url);
	}

}
