package com.anand.collections;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.anand.io.FileFilterTest;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cwd = System.getProperty("user.dir") + File.separator + "target";
		List<File> classFiles = FileFilterTest.findFileByPrefix(new File(cwd), "class");
		Queue<String> q = new LinkedList<String>();
		classFiles.forEach(f -> q.add(f.toPath().getFileName().toString()));
		
		while(q.peek() != null) {
			System.out.println(q.remove());
		}
		System.out.println("Does q have any elements? "+ !q.isEmpty());
		
		//Priority Queue
		Queue<Path> pq = new PriorityQueue<Path>(Comparator.comparing(Path::getFileName));
		classFiles.forEach(f->{
			pq.add(f.toPath().getFileName());
		});
		while(pq.peek() != null) {
			System.out.println(pq.remove());
		}
	}

}
