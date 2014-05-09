package com.adventuremc.start;

import com.adventuremc.elements.Mod;
import com.adventuremc.packageing.Xml;

public class debug {

	static Mod mod = new Mod();
	static Xml xml = new Xml();
	
	static public void main(String args[]){
			mod.name = "a";
	        mod.version = "b";
	        mod.url = "c";
	        mod.file = "d";
	        mod.description = "e";
	        mod.website = "f";
	        mod.md5 = "g";
	        mod.donation = "h";
	        mod.colour = "i";
	        mod.serverurl = "j";
	        mod.serverfile = "k";
	        mod.group = "l";
	        mod.linked = "m";
	        mod.depends = "n";
	        mod.servertype = Mod.EServerType.COREMODS;
	        mod.download = Mod.EDownload.BROWSER;
	        mod.type = Mod.EType.FORGE;
	        mod.client = Mod.EBool.NO;
	        mod.server = Mod.EBool.NO;        
	        mod.library = Mod.EBool.YES;
	        mod.recommended = Mod.EBool.NO;
	        mod.hidden = Mod.EBool.YES;
	        mod.optional = Mod.EBool.YES;
	        mod.serveroptional = Mod.EBool.YES;
	        System.out.println(mod);
	        
	        Mod mo[] = {mod};
	        xml.m = mo;
	        
	        System.out.println(xml);
	}
	
}
