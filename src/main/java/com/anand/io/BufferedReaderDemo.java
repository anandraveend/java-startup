package com.anand.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println("Welcome to the best editor in the whole wide world! Just type 'stop' when you are done");
        String line = null;
        //One way of doing it
//        do{
//            line=br.readLine();
//            sb.append(line).append("\n");
//        }while(line != null && !line.toLowerCase().equals("stop"));
//
        //another approach
        while(!(line=br.readLine()).toLowerCase().equals("stop") ){
            sb.append(line).append("\n");

        }
        System.out.println(sb.toString());
    }
}
