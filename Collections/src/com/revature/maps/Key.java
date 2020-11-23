package com.revature.maps;

public class Key {
	
	/*
	 * This is a custom object to be used inside the map. It's sole purpose is to show of the fact that we can use 
	 * 	our own objects as key or value.
	 */
	
	private String name;

	public Key(String name) {
		super();
		this.name = name;
	}

	public Key() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Key [name=" + name + "]";
	}
	
	

}
