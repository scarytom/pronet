package com.scarytom.pronet;

import java.util.Set;

import com.google.common.collect.Sets;

public class Programmer implements Comparable<Programmer> {
	private final String name;
	private final Set<Programmer> recommendations = Sets.newTreeSet();
	private final Set<String> skills;

	public Programmer(final String name, final Set<String> skills) {
		this.name = name;
		this.skills = skills;
	}

	public Set<Programmer> recommendations() {
		return recommendations;
	}

	public String name() {
		return name;
	}

	public Set<String> skills() {
		return this.skills;
	}

	public void addRecommendation(final Programmer recommendation) {
		this.recommendations.add(recommendation);
	}

	@Override
	public int compareTo(final Programmer o) {
		return name.compareTo(o.name);
	}
}
