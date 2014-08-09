package net.boboman13.spacegdnbridge.response;

import org.json.JSONObject;

/**
 * @author boboman13
 */
public class GDNJar {

	public int id;
	public String name;
	public String site_url;
	public String updated_at;
	public String created_at;
	public String description;

	/**
	 * Instantiates a reference GDNJar instance.
	 * @param object The JSONObject (root of the Jar)
	 */
	public GDNJar(JSONObject object) {
		this.id = object.getInt("id");
		this.name = object.getString("name");
		this.site_url = object.getString("site_url");
		this.updated_at = object.getString("updated_at");
		this.created_at = object.getString("created_at");
		this.description = object.getString("description");
	}

}
