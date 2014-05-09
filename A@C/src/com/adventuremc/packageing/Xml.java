package com.adventuremc.packageing;

import com.adventuremc.elements.Mod;
import com.adventuremc.elements.Library;
import com.adventuremc.elements.Pack;

public class Xml {
	
	public Pack p = null;
	public Library[] l = new Library[0];
	public Mod[] m = new Mod[0];
	
	public String xmlOut(){
		String work = "<version>\n\n";
		
		//pack
		work += "<pack>\n" + p + "\n</pack>\n\n";
		
		//library
		work += "<libraries>\n";
		
		for(Library lib:l)
			work += lib + "\n";
		
		work += "</libraries>\n\n";
		
		//mods
		work += "<mods>\n";
		
		for(Mod mod:m)
			work += mod + "\n";
		
		work += "</mods>\n\n";
		
		work += "</version>";
		return work;
	}
	
	public String toString(){
		return xmlOut();
	}
	
}
