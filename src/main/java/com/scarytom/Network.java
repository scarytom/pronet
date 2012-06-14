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
			result += "\n" + p.name() + "\t" + "\t" + getRecommendations(p);
		}
		return result;
	}

	private String getRecommendations(final Programmer p) {
		Set<Programmer> recommendations = p.recommendations();
		String result = "";
		int i = 0;
		for (Programmer recommendation : recommendations) {
			if (i != 0) {
				result += ", ";
			}
			result += recommendation.name();
			i++;
		}
		return result;
	}

	public Set<Programmer> programmers() {
		return _programmers;
	}
}
