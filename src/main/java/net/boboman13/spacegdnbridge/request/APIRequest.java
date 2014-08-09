package net.boboman13.spacegdnbridge.request;

import net.boboman13.spacegdnbridge.Bridge;
import net.boboman13.spacegdnbridge.response.APIResponse;
import net.boboman13.spacegdnbridge.response.BridgeException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author boboman13
 */
public class APIRequest {

	protected Bridge bridge;
	protected RequestType type;

	protected int page = 1;

	protected ArrayList<String> segments = new ArrayList<String>();

	/**
	 * Instantiates a new APIRequest.
	 * @param bridge
	 */
	public APIRequest(Bridge bridge) {
		this.bridge = bridge;
	}

	/**
	 * Gets a specific object.
	 * @param object
	 * @return
	 */
	public APIRequest get(String object) {
		String segment = object.substring(0, object.length() - 1);
		this.segments.add(segment);

		setRequestType(segment);

		return this;
	}

	/**
	 * Selects a channel.
	 * @param id
	 * @return
	 */
	public APIRequest channel(int id) {
		this.segments.add("channel");
		this.segments.add(Integer.toString(id));

		this.type = RequestType.CHANNEL;

		return this;
	}

	/**
	 * Selects a version.
	 * @param id
	 * @return
	 */
	public APIRequest version(int id) {
		this.segments.add("version");
		this.segments.add(Integer.toString(id));

		this.type = RequestType.VERSION;

		return this;
	}

	/**
	 * Selects a Jar.
	 * @param id
	 * @return
	 */
	public APIRequest jar(int id) {
		this.segments.add("jar");
		this.segments.add(Integer.toString(id));

		this.type = RequestType.JAR;

		return this;
	}

	/**
	 * Selects a build.
	 * @param id
	 * @return
	 */
	public APIRequest build(int id) {
		this.segments.add("build");
		this.segments.add(Integer.toString(id));

		this.type = RequestType.BUILD;

		return this;
	}

	/**
	 * Paginates the result data.
	 * @param page
	 * @return
	 */
	public APIRequest page(int page) {
		this.page = page;

		return this;
	}

	/**
	 * Gets the RequestType.
	 * @return
	 */
	public RequestType getRequestType() {
		return this.type;
	}

	/**
	 * Gets the Bridge.
	 * @return
	 */
	public Bridge getBridge() {
		return this.bridge;
	}

	/**
	 * Set the RequestType.
	 * @param type
	 */
	private void setRequestType(String type) {
		if (type.equalsIgnoreCase("build"))
			this.type = RequestType.BUILD;
		else if (type.equalsIgnoreCase("jar"))
			this.type = RequestType.JAR;
		else if (type.equalsIgnoreCase("version"))
			this.type = RequestType.VERSION;
		else if (type.equalsIgnoreCase("channel"))
			this.type = RequestType.CHANNEL;
	}

	/**
	 * Builds the URL for the request.
	 * @return
	 */
	private String buildUrl() throws BridgeException {
		String url = bridge.getHost();

		// append version
		url += "/" + bridge.getVersion();

		// append segments
		if (this.segments.size() < 1) {
			throw new BridgeException("Must supply at least one URL parameter.");
		}

		for (String segment : this.segments) {
			url += "/" + segment;
		}

		// paginate
		url += "?page=" + this.page;

		// debug
		if (this.bridge.getDebug()) {
			System.out.println("Using URL: " + url + ".");
		}

		return url;
	}

	/**
	 * Launches the APIRequest.
	 */
	public APIResponse go() throws BridgeException {
		HttpClient client = new DefaultHttpClient(); // I know this is deprecated, but I'm not sure what to use instead.
		HttpGet method = new HttpGet(this.buildUrl());

		// must accept JSON
		method.addHeader("Accept", "application/json");
		method.addHeader("User-Agent", "SpaceGDN-Java-Client");

		String content = "";

		try {
			// execute
			HttpResponse response = client.execute(method);

			// get back response
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line;
			while ((line = rd.readLine()) != null) {
				content += line;
			}

		} catch (Exception ex) {
			throw new BridgeException(ex.getMessage());
		}

		// parse to JSON
		JSONObject object = new JSONObject(content);
		APIResponse responseObject = new APIResponse(this, object);

		return responseObject;
	}

}
