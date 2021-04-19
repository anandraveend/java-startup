package com.anand.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cwd = System.getProperty("user.dir");		
		String targetFile = cwd + File.separatorChar + "target" + File.separatorChar + "testfile.txt";
		try(FileOutputStream fout = new FileOutputStream(targetFile)){
			fout.write(args[0].getBytes());
			fout.write(System.getProperty("line.separator").getBytes());
			//Did we write it..for real??
			FileReaderDemo.readFile(targetFile);
		}catch(IOException e) {
			
		}
	}

}
