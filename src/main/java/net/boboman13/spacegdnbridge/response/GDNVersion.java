package net.boboman13.spacegdnbridge.response;

import org.json.JSONObject;

/**
 * @author boboman13
 */
public class GDNVersion {

	public int id;
	public int jar_id;
	public int channel_id;
	public String version;
	public String created_at;
	public String updated_at;

	/**
	 * Creates a GDNVersion.
	 * @param object
	 */
	public GDNVersion(JSONObject object) {
		this.id = object.getInt("id");
		this.jar_id = object.getInt("jar_id");
		this.channel_id = object.getInt("channel_id");
		this.version = object.getString("version");
		this.created_at = object.getString("created_at");
		this.updated_at = object.getString("updated_at");
	}

}
