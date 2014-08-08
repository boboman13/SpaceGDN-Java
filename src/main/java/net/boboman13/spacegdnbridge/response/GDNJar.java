package net.boboman13.spacegdnbridge.response;

import org.json.JSONObject;

/**
 * @author boboman13
 */
public class GDNJar {

	// The properties
	protected int id;
	protected String name;
	protected String site_url;
	protected String updated_at;
	protected String created_at;
	protected String description;

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

	/**
	 * Gets the ID of the Jar.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name of the Jar.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the Jar's site URL.
	 * @return
	 */
	public String getSiteUrl() {
		return site_url;
	}

	/**
	 * Gets when the Jar was updated at.
	 * @return
	 */
	public String getUpdatedAt() {
		return updated_at;
	}

	/**
	 * Gets when the Jar was created.
	 * @return
	 */
	public String getCreatedAt() {
		return created_at;
	}

	/**
	 * Gets the Jar's description.
	 * @return
	 */
	public String getDescription() {
		return description;
	}

}
