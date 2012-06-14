package com.scarytom;

import java.util.HashSet;
import java.util.Set;

import com.scarytom.pronet.Programmer;

public class Network {

	private final Set<Programmer> _programmers = new HashSet<Programmer>();

	public Network(final Programmer programmer) {
		_programmers.add(programmer);
	}

	public String printout() {
		return "Programmer\tSkills\tRecommends";
	}

	public Set<Programmer> programmers() {
		return _programmers;
	}
}
