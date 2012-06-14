package com.scarytom.pronet;

import java.util.List;
import java.util.Set;

public class Programmer {
	private final String name;
	private final Set<Programmer> recommendations;

	public Programmer(String name, Set<Programmer> recommendations) {
		this.name = name;
		this.recommendations = recommendations;
	}

	public Set<Programmer> recommendations(){
		return recommendations;
	}
	
	public String name(){
		return name;
	}
	
	public Set<String> skills(){
		return null;
	}
}
