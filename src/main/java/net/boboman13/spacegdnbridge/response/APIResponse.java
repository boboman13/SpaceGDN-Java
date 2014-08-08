package net.boboman13.spacegdnbridge.response;

import net.boboman13.spacegdnbridge.request.APIRequest;
import org.json.JSONObject;

/**
 * @author boboman13
 */
public class APIResponse {

	private APIRequest request;
	public JSONObject root = null;

	public APIResponse(APIRequest request, JSONObject object) {
		this.request = request;
		this.root = object;
	}

}
