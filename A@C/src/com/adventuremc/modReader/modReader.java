package com.adventuremc.modReader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.adventuremc.elements.ModId;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class modReader {
	
	File target = null;
	ModId mi = null;

	public modReader(File f){
		try {
			target = tempFile();
			unzipFile(f,target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(target.length() == 0){
			System.out.println("fail");
		}
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(target));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JsonParser parser = new JsonParser();
	    JsonArray jArray = parser.parse(isr).getAsJsonArray();
	    JsonObject jo = parser.parse(jArray.get(0).toString()).getAsJsonObject();
	    mi = new ModId(jo);
	}
	
	public ModId getModId(){
		return mi;
	}

	public void unzipFile(File zip,File destination) throws IOException{
		OutputStream out = new FileOutputStream(destination);
		FileInputStream fin = new FileInputStream(zip);
		BufferedInputStream bin = new BufferedInputStream(fin);
		ZipInputStream zin = new ZipInputStream(bin);
		ZipEntry ze = null;
		while ((ze = zin.getNextEntry()) != null) {
		    if (ze.getName().equals("mcmod.info")) {
		        byte[] buffer = new byte[8192];
		        int len;
		        while ((len = zin.read(buffer)) != -1) {
		            out.write(buffer, 0, len);
		        }
		        out.close();
		        break;
		    }
		}
		zin.close();
    }
	
	public File tempFile() throws IOException{
		File file = Files.createTempFile("xml",".info").toFile();
		return file;
	}
	
}
