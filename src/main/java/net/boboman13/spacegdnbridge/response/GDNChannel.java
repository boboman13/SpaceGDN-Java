package net.boboman13.spacegdnbridge.response;

import org.json.JSONObject;

/**
 * @author boboman13
 */
public class GDNChannel {

	public int id;
	public int jar_id;
	public String name;
	public String created_at;
	public String updated_at;

	/**
	 * Creates a GDNChannel.
	 * @param object
	 */
	public GDNChannel(JSONObject object) {
		this.id = object.getInt("id");
		this.jar_id = object.getInt("jar_id");
		this.name = object.getString("name");
		this.created_at = object.getString("created_at");
		this.updated_at = object.getString("updated_at");
	}

}
