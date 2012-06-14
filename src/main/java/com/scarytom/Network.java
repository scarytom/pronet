package com.scarytom;

import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;

public class Network {

	private static final String HEADER = "Programmer\tSkills\tRecommends";
	private final TreeSet<Programmer> _programmers;

	public Network(final Set<Programmer> programmers) {
		_programmers = Sets.newTreeSet(programmers);
	}

	public String printout() {

		return HEADER + printProgrammers();
	}

	private String printProgrammers() {
		String result = "";
		for (Programmer p : _programmers) {
			result += "\n" + p.name() + "\t" + getSkills(p) + "\t"
					+ getRecommendations(p);
		}
		return result;
	}

	private String getSkills(final Programmer p) {
		Set<String> skills = p.skills();
		int i = 0;
		String result = "";
		for (String skill : skills) {
			if (i != 0) {
				result += ", ";
			}
			result += skill;
			i++;

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
