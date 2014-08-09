package net.boboman13.spacegdnbridge.response;

import net.boboman13.spacegdnbridge.request.APIRequest;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author boboman13
 */
public class APIResponse {

	protected APIRequest request;
	protected JSONObject root = null;

	public String error = null;
	public boolean success = false;

	// Response values
	public GDNChannel channel = null;
	public GDNVersion version = null;
	public GDNJar jar = null;
	public GDNBuild build = null;

	public GDNChannel[] channels = null;
	public GDNVersion[] versions = null;
	public GDNJar[] jars = null;
	public GDNBuild[] builds = null;

	/**
	 * Creates an APIResponse object.
	 * @param request
	 * @param object
	 */
	public APIResponse(APIRequest request, JSONObject object) {
		this.request = request;
		this.root = object;

		// handle success
		this.success = object.getBoolean("success");

		// handle error
		JSONObject error = object.getJSONObject("error");
		if (error.has("message")) {
			this.error = error.getString("message");
			return;
		}

		// handle results
		JSONArray array = object.getJSONArray("results");
		if (true) {
			// handle singles
			switch (request.getRequestType()) {
				case CHANNEL:
					this.channel = new GDNChannel(array.getJSONObject(0));
					return;
				case VERSION:
					this.version = new GDNVersion(array.getJSONObject(0));
					return;
				case JAR:
					this.jar = new GDNJar(array.getJSONObject(0));
					return;
				case BUILD:
					this.build = new GDNBuild(array.getJSONObject(0));
					return;
			}
		} else {
			// handle multiple
			switch (request.getRequestType()) {
				case CHANNEL:
					GDNChannel[] channels = new GDNChannel[array.length()];
					for (int i = 0; i < array.length(); i++) {
						channels[i] = new GDNChannel(array.getJSONObject(i));
					}

					this.channels = channels;
					return;
				case VERSION:
					GDNVersion[] versions = new GDNVersion[array.length()];
					for (int i = 0; i < array.length(); i++) {
						versions[i] = new GDNVersion(array.getJSONObject(i));
					}

					this.versions = versions;
					return;
				case JAR:
					GDNJar[] jars = new GDNJar[array.length()];
					for (int i = 0; i < array.length(); i++) {
						jars[i] = new GDNJar(array.getJSONObject(i));
					}

					this.jars = jars;
					return;
				case BUILD:
					GDNBuild[] builds = new GDNBuild[array.length()];
					for (int i = 0; i < array.length(); i++) {
						builds[i] = new GDNBuild(array.getJSONObject(i));
					}

					this.builds = builds;
					return;
			}
		}

	}



}
