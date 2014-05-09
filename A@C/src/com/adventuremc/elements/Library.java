package com.adventuremc.elements;

public class Library {
		
		//enums
		public enum EDownload {DIRECT, SERVER};
		
		//vars and defaults
		public String name = null;
		public String version = null;
		public String url = null;
		public String file = null;
		public String server = null; //optional (but required in needed on server)
		public String md5 = null; //optional
		public String depends = null; //optional
		public EDownload download = EDownload.SERVER;
		
		
}
