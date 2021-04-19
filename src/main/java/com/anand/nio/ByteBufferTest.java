package com.anand.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(16);
		printBufferInfo(bb);
		//reset tracker to start
		bb.flip();
		
		int i=50;
		while(bb.hasRemaining()) {
			bb.put((byte)i++);
		}
		
		//for every operation, you need to flip back to read
		bb.flip();
		printBufferInfo(bb);

	}
	
	public static void printBufferInfo(ByteBuffer bb) {
		int limit = bb.limit();
		System.out.println(String.format("Position = %d Limit = %d", bb.position(),bb.limit()));
		System.out.println("Data in buffer :");
		while(bb.hasRemaining()) {
			System.out.print(bb.get() + " ");
		}
		System.out.println();
	}

}
