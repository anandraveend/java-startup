package com.anand.generics;

public class GenericWrapper<T> {
	private T ref;
	public GenericWrapper(T ref){
		this.ref = ref;
		System.out.println("Created a GenericWrapper of type " + ref.getClass().getName());
	}
	public void setWrapper(T ref) {
		this.ref = ref;
		System.out.println("Set ref's value to " + ref);
	}
	
	public T getWrapper() {
		return ref;
	}
}
