package com.scarytom.pronet;

import java.util.Set;

public class Programmer {
	private final String name;
	private final Set<Programmer> recommendations;

	public Programmer(final String name, final Set<Programmer> recommendations) {
		this.name = name;
		this.recommendations = recommendations;
	}

	public Set<Programmer> recommendations() {
		return recommendations;
	}

	public String name() {
		return name;
	}

	public Set<String> skills() {
		return null;
	}

	public void addRecommendation(final Programmer recommendation) {
		this.recommendations.add(recommendation);
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
		result = prime * result
				+ ((recommendations == null) ? 0 : recommendations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recommendations == null) {
			if (other.recommendations != null)
				return false;
		} else if (!recommendations.equals(other.recommendations))
			return false;
		return true;
	}
}
