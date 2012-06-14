package com.scarytom;

import java.io.IOException;
import java.util.Set;

import nu.xom.ParsingException;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;

public class DegreesOfSeparationFinder {
	private final UndirectedGraphBuilder undirectedGraphBuilder;
	
	public static void main(String[] args) throws Exception {
		Network network = NetworkBuilder.buildNetwork(args[0]).build();
		Set<Programmer> programmers = network.programmers();
		DegreesOfSeparationFinder degreesOfSeparationFinder = new DegreesOfSeparationFinder(programmers);
		for (Programmer p1 : programmers) {
			System.out.print(p1.name() + " ");
		}
		System.out.println();
		for (Programmer p1 : programmers) {
			System.out.print(p1.name());
			for (Programmer p2 : programmers) {
				System.out.print(" " + degreesOfSeparationFinder.degreesOfSeparationBetween(p1, p2));
			}
			System.out.println();
		}
	}

	public DegreesOfSeparationFinder(Set<Programmer> programmers) {
		undirectedGraphBuilder = new UndirectedGraphBuilder(programmers);
	}

	public int degreesOfSeparationBetween(Programmer p1, Programmer p2) {
		return sep(links(p1), p2, 1);
	}
	
	private int sep(Set<Programmer> links, Programmer p2, int i) {
		if (links.contains(p2)) {
			return i;
		}
		Set<Programmer> links2 = Sets.newHashSet();
		for (Programmer programmer : links) {
			links2.addAll(links(programmer));
		}
		return sep(links2, p2, i+1);
	}

	private Set<Programmer> links(Programmer p) {
		Set<Programmer> recommendations = p.recommendations();
		Set<Programmer> recommenders = undirectedGraphBuilder.whoRecommends(p);
		Set<Programmer> result = Sets.newHashSet();
		result.addAll(recommendations);
		result.addAll(recommenders);
		return result;
	}
}
