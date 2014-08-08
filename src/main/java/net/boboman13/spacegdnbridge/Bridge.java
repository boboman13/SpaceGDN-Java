package net.boboman13.spacegdnbridge;

import net.boboman13.spacegdnbridge.request.APIRequest;

/**
 * @author boboman13
 */
public class Bridge {

	protected String host = "http://gdn.api.xereo.net";
	protected String version = "v1";

	protected boolean debug = false;

	/**
	 * Creates a Bridge. Utilizes the default host (http://gdn.api.xereo.net).
	 */
	public Bridge() {

	}

	/**
	 * Creates a Bridge with a specified host.
	 * @param host The host of the SpaceGDN host. Formatted like "http://gdn.api.xereo.net".
	 */
	public Bridge(String host) {
		this.host = host;
	}

	/**
	 * Creates a new APIRequest for querying.
	 * @return
	 */
	public APIRequest newRequest() {
		return new APIRequest(this);
	}

	/**
	 * Gets debug mode value.
	 * @return
	 */
	public boolean getDebug() {
		return this.debug;
	}

	/**
	 * Sets debug mode.
	 * @param debug
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Gets the host.
	 * @return
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Gets the version.
	 * @return
	 */
	public String getVersion() {
		return this.version;
	}

}
