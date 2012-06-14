package com.scarytom;

import static com.google.common.collect.Sets.newHashSet;

import java.util.HashSet;
import java.util.Set;

import com.scarytom.pronet.Programmer;

public class UndirectedGraphBuilder {
	public UndirectedGraphBuilder(Set<Programmer> programmers) {
	}

	public Set<Programmer> whoRecommends(Programmer programmer) {
		Set<Programmer> recommendations = newHashSet();
		Programmer davie = new Programmer("davie", new HashSet<Programmer>());
		recommendations.add(davie);
		
		Programmer tom = new Programmer("tom", recommendations);

		return newHashSet(tom);
	}
}
