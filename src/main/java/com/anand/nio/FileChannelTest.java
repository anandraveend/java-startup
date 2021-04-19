package com.anand.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import com.anand.io.FileFilterTest;

public class FileChannelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = System.getProperty("user.dir") + File.separator + "target" + File.separator + "allJavaFiles.txt";
		File fl = new File(fileName);
		try {
			writeFileChannel(fl);
			readFileChannel(fl);
		}catch(Exception e) {
			
		}

	}
	
	public static void readFileChannel(File fl) throws Exception{
		if(!fl.exists()) {
			throw new Exception("File does not exist!");
		}
		try(FileChannel fc = new FileInputStream(fl).getChannel()){
			ByteBuffer bb = ByteBuffer.allocate(1024);
			while(fc.read(bb) > 0) {
				bb.flip();
				while(bb.hasRemaining()) {
					System.out.print((char)bb.get());
				}
				bb.clear();
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void writeFileChannel(File fl) {
		try(FileChannel fc = new FileOutputStream(fl).getChannel()){
			String data = getTestData();
			byte[]byteData = data.getBytes();
			ByteBuffer bb = ByteBuffer.wrap(byteData);
			fc.write(bb);
			System.out.println("File written to " + fl.getAbsolutePath());
		}catch(Exception e) {
			
		}
	}
	
	public static String getTestData() {
		File cwd = new File(System.getProperty("user.dir"));
		ArrayList<File> javaFiles = (ArrayList<File>)FileFilterTest.findFileByPrefix(cwd, "java");
		StringBuilder sb = new StringBuilder();
		String lineSeparator = System.getProperty("line.separator");
		javaFiles.forEach( fl ->{
			sb.append(fl.getName());
			sb.append(lineSeparator);
		});
		return sb.toString();
	}

}
