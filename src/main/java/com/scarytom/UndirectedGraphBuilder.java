package com.scarytom;

import static com.google.common.collect.Sets.newHashSet;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;

public class UndirectedGraphBuilder {
	public UndirectedGraphBuilder(Set<Programmer> programmers) {
	}

	public Set<Programmer> whoRecommends(Programmer programmer) {
		Programmer davie = new Programmer("davie", Sets.<String>newHashSet());
		Programmer tom = new Programmer("tom", Sets.<String>newHashSet());
        tom.addRecommendation(davie);
		return newHashSet(tom);
	}
}
