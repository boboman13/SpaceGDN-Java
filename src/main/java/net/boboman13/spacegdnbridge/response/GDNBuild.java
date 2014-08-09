package net.boboman13.spacegdnbridge.response;

import org.json.JSONObject;

/**
 * @author boboman13
 */
public class GDNBuild {

	public int id;
	@Deprecated
	public int size;
	public int build;
	public int jar_id;
	public String url;
	public int version_id;
	public int channel_id;
	@Deprecated
	public String checksum;
	public String created_at;
	public String updated_at;

	public GDNBuild(JSONObject object) {
		this.id = object.getInt("id");
		//this.size = object.getInt("size"); - unused
		this.build = object.getInt("build");
		this.jar_id = object.getInt("jar_id");
		this.url = object.getString("url");
		this.version_id = object.getInt("version_id");
		this.channel_id = object.getInt("channel_id");
		//this.checksum = object.getString("checksum"); - unused
		this.created_at = object.getString("created_at");
		this.updated_at = object.getString("updated_at");
	}

}
