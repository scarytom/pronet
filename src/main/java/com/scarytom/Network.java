package com.scarytom;

import java.util.Set;

import com.scarytom.pronet.Programmer;

public class Network {

	private static final String HEADER = "Programmer\tSkills\tRecommends";
	private final Set<Programmer> _programmers;

	public Network(final Set<Programmer> programmers) {
		_programmers = programmers;
	}

	public String printout() {

		return HEADER + printProgrammers();
	}

	private String printProgrammers() {
		String result = "";
		for (Programmer p : _programmers) {
			result += "\n" + p.name() + "\t" + "\t";
		}
		return result;
	}

	public Set<Programmer> programmers() {
		return _programmers;
	}
}
