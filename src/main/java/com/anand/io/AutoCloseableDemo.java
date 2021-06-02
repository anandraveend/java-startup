package com.anand.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AutoCloseableDemo implements AutoCloseable{
    FileInputStream fin;

    AutoCloseableDemo(String filepath)throws FileNotFoundException{
        try {
            fin=new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file "+filepath);
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        if(fin!=null){
            fin.close();
        }
    }

    public static void main(String[] args) {
        try(AutoCloseable c = new AutoCloseableDemo("/Users/anandraveendran/test.xml")){
            int i;
            while((i=((AutoCloseableDemo) c).fin.read())!= -1){
                System.out.print((char)i);
            }
        }catch (Exception e){

        }
    }
}
