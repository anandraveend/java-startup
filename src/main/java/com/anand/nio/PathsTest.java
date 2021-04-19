package com.anand.nio;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import com.anand.io.FileFilterTest;

public class PathsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File cwd = new File(System.getProperty("user.dir"));
		ArrayList<File> javaFiles = (ArrayList<File>)FileFilterTest.findFileByPrefix(cwd, "java");
		javaFiles.forEach(fl ->{
			Path path = fl.toPath();
			printPathDetails(path);
		});

	}
	
	public static void printPathDetails(Path p) {
		System.out.println("Details for file :" + p.getFileName());
		System.out.println("Folders in the path :" + (p.getNameCount()-1));
		System.out.println("Root folder : " + p.getRoot());
		System.out.println("Parent folder : " + p.getParent().getFileName());
		System.out.println("===================================");
	}

}
