package fr.titouz.gamewatch.tools;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Repertoire {
	
	public static ArrayList<String> getListeFichiers() {
		ArrayList<String> fichiers = new ArrayList<>();
		File dir = new File("C:\\titzwatch");
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				 return name.toLowerCase().endsWith(".titz");
			}
		};
		if(dir != null) {
			if(dir.listFiles(filter) != null) {
				for(File f : dir.listFiles(filter)) {
					String name = f.getName();
					int pos = name.lastIndexOf(".");
					if (pos > 0) {
					    name = name.substring(0, pos);
					}
					fichiers.add(name.replaceAll("_"," "));
				}
			}
		}
		
		return fichiers;
	}

}
