package com.anand.innerclasses;

import java.util.ArrayList;
import java.util.Iterator;

public class TitleListAnonymous {
	private ArrayList<String> titleList = new ArrayList<String>();
	
	public void addTitle(String title) {
		titleList.add(title);
	}
	
	public void removeTitle(String title) {
		titleList.remove(title);
	}
	
	public Iterator<String> titleIterator() {
		Iterator<String> it = new Iterator<String>() {
			int count = 0;
			@Override
			public boolean hasNext() {
				return count < titleList.size();
			}
			
			public String next() {
				return titleList.get(count++);
			}
		};
		return it;
	}

}
