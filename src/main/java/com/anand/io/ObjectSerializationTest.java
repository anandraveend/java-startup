package com.anand.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.anand.decorator.*;
public class ObjectSerializationTest {

	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir");
		String filePath = cwd + File.pathSeparator + "target" + "ObjPickle.txt";
		File fl = new File(filePath);
		serializeTest(fl);
		deSerializeTest(fl);
	}
	
	public static void serializeTest(File fl) {
		Whiskey w = new Whiskey();
		Honey hw = new Honey(new Whiskey());
		Spicey shw = new Spicey(new Honey(new Whiskey()));
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fl))){
			os.writeObject(w);
			os.writeObject(hw);
			os.writeObject(shw);
			System.out.println(String.format("Wrote %s to file %s", w.toString(),fl.getCanonicalFile()));
			System.out.println(String.format("Wrote %s to file %s", hw.toString(),fl.getCanonicalFile()));
			System.out.println(String.format("Wrote %s to file %s", shw.toString(),fl.getCanonicalFile()));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void deSerializeTest(File fl) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(fl))){
			Drink d = null;
			while((d =(Drink) is.readObject())!= null) {
				System.out.println("De-serialized " + d.toString());
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
