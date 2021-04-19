package com.anand.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

public class Watcher {

	public static void main(String[] args) {
		try(WatchService ws = FileSystems.getDefault().newWatchService()){
			//Get path to directory to watch
			Path dir2watch = Paths.get(System.getProperty("user.dir"));
			
			//Register the type of events to watch for
			dir2watch.register(ws, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
			
			while(true) {
				WatchKey key = ws.take();
				for(WatchEvent<?>event : key.pollEvents()) {
					Kind<?>eventKind = event.kind();
					if(eventKind == OVERFLOW) {
						System.out.println("Event overflow !");
						continue;
					}
					WatchEvent<Path> currEvent = (WatchEvent<Path>) event;
					Path dirEntry = currEvent.context();
					System.out.println(eventKind +" event occurred in "+ dirEntry);
					
					// Reset the key
					boolean isKeyValid = key.reset();
					if (!isKeyValid) {
					System.out.println("No longer watching " + dir2watch);
					break;
					}
				}
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
