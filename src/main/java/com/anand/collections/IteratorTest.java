package com.anand.collections;

import java.io.File;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

import com.anand.io.FileFilterTest;

public class IteratorTest {
	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir") + File.separator + "target";
		List<File> classFiles = FileFilterTest.findFileByPrefix(new File(cwd), "class");
		Iterator<File> it = classFiles.iterator();
		
		while(it.hasNext()) {
			File fl = it.next();
			Path path = fl.toPath();
			System.out.println(String.format("Class file %s in folder %s", path.getFileName(),path.getParent().getFileName()));
		}
		
		//lambda expression form
		classFiles.iterator().forEachRemaining(System.out::println);
	}
}
