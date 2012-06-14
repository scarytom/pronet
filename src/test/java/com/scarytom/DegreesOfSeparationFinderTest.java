package com.scarytom;

import static junit.framework.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;

public class DegreesOfSeparationFinderTest {
	@Test
	public void canFindDirectlyLinkedRecommendee() throws Exception {
		Programmer tom = new Programmer("tom", Sets.<String>newHashSet());
		Programmer davie = new Programmer("davie", Sets.<String>newHashSet());
		
		tom.addRecommendation(davie);
		
		Set<Programmer> programmers = Sets.newHashSet(tom, davie);
		
		DegreesOfSeparationFinder degreesOfSeparationFinder = new DegreesOfSeparationFinder(programmers);
		assertEquals(1, degreesOfSeparationFinder.degreesOfSeparationBetween(tom, davie));
	}
}
