package com.scarytom.pronet;

import java.util.Set;

import com.google.common.collect.Sets;

public class Programmer implements Comparable<Programmer> {
	private final String name;
	private final Set<Programmer> recommendations = Sets.newTreeSet();
	private final Set<String> skills;

	public Programmer(final String name, final Set<String> skills) {
		this.name = name;
		this.skills = Sets.newTreeSet(skills);
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

	public double getKudos() {
		return 0.0;
	}
	@Override
	public String toString() {
		return "Programmer [name=" + name + ", recommendations="
				+ recommendations + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Programmer other = (Programmer) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(final Programmer o) {
		return name.compareTo(o.name);
	}
}
