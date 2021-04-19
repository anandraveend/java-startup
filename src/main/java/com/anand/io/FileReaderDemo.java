package com.anand.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String [] args) {
		FileReaderDemo.readFile(args[0]);
	}
	public static void readFile(String filename) {
		try(FileInputStream fin = new FileInputStream(filename)){
			byte byteData;
			while((byteData = (byte)fin.read())!= -1) {
				System.out.println((char)byteData);
			}
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
