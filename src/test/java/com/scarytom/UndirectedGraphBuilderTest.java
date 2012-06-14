package com.scarytom;

import static com.google.common.collect.Sets.newHashSet;
import static junit.framework.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.scarytom.pronet.Programmer;

public class UndirectedGraphBuilderTest {
	@Test
	public void createsGraphWithTwoNodes() throws Exception {
		Set<Programmer> recommendations = newHashSet();
		Programmer davie = new Programmer("davie", new HashSet<Programmer>());
		recommendations.add(davie);
		
		Programmer tom = new Programmer("tom", recommendations);
		
		UndirectedGraphBuilder graphBuilder = new UndirectedGraphBuilder(newHashSet(davie, tom));
		Set<Programmer> recommenders = graphBuilder.whoRecommends(davie);
		assertEquals(newHashSet(tom), recommenders);
	}
}
