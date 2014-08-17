package com.adventuremc.elements;



public class Mod {

	
	//enums
	public enum EDownload {DIRECT, SERVER, BROWSER};
	public enum EType {JAR,FORGE,MODS,COREMODS,MCPC,PLUGINS,EXTRACT,DECOMP,RESOURCEPACK,MILLAIRE,TEXTUREPACK,TEXTUREPACKEXTRACT,RESOURCEPACKEXTRACT,DEPENDENCY};
	public enum EServerType {JAR,FORGE,MODS,COREMODS,MCPC,PLUGINS,EXTRACT,DECOMP,MILLAIRE,NULL};
	public enum EBool {YES,NO,SEPERATE}; //SEPERATE is for server only
	
	//vars and defaults
	public String name = "null";
	public String version = "null";
	public String url = "null";
	public String file = "null";
	public String description = "null";
	public String website = "null";
	public String md5 = null; //optional
	public String donation = null; //optional
	public String colour = null; //optional
	public String serverurl = null; //optional (1.2.5 last)
	public String serverfile = null; //optional (1.2.5 last)
	public String group = null; //optional
	public String linked = null; //optional
	public String depends = null; //optional
	public EServerType servertype = EServerType.NULL; //optional (1.2.5 last)
	public EDownload download = EDownload.SERVER;
	public EType type = EType.MODS;
	public EBool client = EBool.YES; 
	public EBool server = EBool.YES;
	public EBool library = EBool.NO;
	public EBool recommended = EBool.YES;
	public EBool hidden = EBool.NO; //optional
	public EBool optional = EBool.NO; //optional
	public EBool serveroptional = EBool.NO; //optional
	
	public boolean isNull(String str){
		if (str == null)
			return false;
		if (str.isEmpty())
			return false;
		return true;
	}
	
	public String[] getStrings(){
		String ret[] = {name,version,url,file,description,website,md5,donation,colour,serverurl,serverfile,group,linked,depends};
		return ret;
	}
	
	public String[] getNames(){
		String ret[] = {"name","version","url","file","description","website","md5","donation","colour","serverurl","serverfile","group","linked","depends"};
		return ret;
	}
	
	public EBool[] getEBools(){
		EBool ret[] = {client,server,library,recommended,hidden,optional,serveroptional};
		return ret;
	}
	
	public String[] getEBoolNames(){
		String ret[] = {"client","server","library","recommended","hidden","optional","serveroptional"};
		return ret;
	}
	
	public String xmlout(){
		String work = "<mod ";
		
		//set strings
		for(int i = 0; i <= 13; i++){
			if(isNull(getStrings()[i]))
				work += getNames()[i] + "=\"" + getStrings()[i] + "\" ";
		}
		
		if(!(servertype == EServerType.NULL))
			work += "servertype=\"" + servertype.toString().toLowerCase() + "\" ";
		
		work += "download=\"" + download.toString().toLowerCase() + "\" ";
		work += "type=\"" + type.toString().toLowerCase() + "\" ";
		
		for(int i = 0; i <= 6; i++){
			work += getEBoolNames()[i] + "=\"" + getEBools()[i].toString().toLowerCase() + "\" ";
		}
		
		work += "/>";
		return work;
	}
	
	public String toString(){
		return xmlout();
	}
	
}
