package com.anand.io;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileFilterTest {
	public static void main(String[] args) {
		FileFilter isJava = f -> {
			if(f.isFile()) {
				String fName = f.getName().toLowerCase();
				if(fName.endsWith("java"))
					return true;
			}
			return false;
		};
		File cwd= new File(System.getProperty("user.dir"));
		ArrayList<File> files = walkDir(cwd);
		
		System.out.println(String.format("List of .java files found in %s", System.getProperty("user.dir")));
		List<File> jFiles = files.stream().filter(p->{
			String fName = p.getName().toLowerCase();
			if(fName.endsWith("java"))
				return true;
			return false;
		}).collect(Collectors.toList());
		for(File f:jFiles) {
			System.out.println(f.getAbsolutePath());
		}
	}
	
	public static ArrayList<File> walkDir(File dir) {
		ArrayList<File> allFiles = new ArrayList<File>();
		if(dir.isFile()) {
			allFiles.add(dir);
			return allFiles;
		}
		for(File f: dir.listFiles()) {
			if(f.isDirectory()) {
				allFiles.addAll(FileFilterTest.walkDir(f));
			}else {
				allFiles.add(f);
			}				
		}
		return allFiles;
	}
	
	public static File[] merge(File[] a, File[] b){
		if(a == null) {
			return b;
		}else if (b == null) {
			return a;
		}else {
			int size = a.length + b.length;
			File[] dir = new File[size];
			for(int i=0;i< a.length;i++) {
				dir[i]=a[i];
			}
			for(int i=0;i<b.length;i++) {
				dir[dir.length+i] = b[i];
			}
			return dir;
		}
	}
}
