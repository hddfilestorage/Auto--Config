package com.adventuremc.elements;

import com.google.gson.JsonObject;

public class ModId {

	public String name = null;
	public String description = null;
	public String version = null;
	public String url = null;
	
	public ModId(JsonObject jo){
		if(jo.has("name"))
			name = jo.get("name").toString().replace("\"", "");
		if(jo.has("description"))
			description = jo.get("description").toString().replace("\"", "");
		if(jo.has("version"))
			version = jo.get("version").toString().replace("\"", "");
		if(jo.has("url"))
			url = jo.get("url").toString().replace("\"", "");
	}
}
