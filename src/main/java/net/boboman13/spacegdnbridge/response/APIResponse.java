package net.boboman13.spacegdnbridge.response;

import net.boboman13.spacegdnbridge.request.APIRequest;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author boboman13
 */
public class APIResponse {

	private APIRequest request;
	protected JSONObject root = null;

	private String error = null;
	private boolean success = false;

	// Response values
	protected GDNJar jar = null;

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
		String error = object.getString("error");
		if (error.length() > 0) {
			this.error = error;
			return;
		}

		// handle results
		JSONArray array = object.getJSONArray("results");
		if (true) {
			// handle singles
			switch (request.getRequestType()) {
				case CHANNEL:
				case VERSION:
				case JAR:
					this.jar = new GDNJar(array.getJSONObject(1));
					return;
				case BUILD:
			}
		} else {
			// handle multiple
		}

	}



}
