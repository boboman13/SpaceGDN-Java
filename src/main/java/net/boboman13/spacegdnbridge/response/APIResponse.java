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
		}

	}



}
