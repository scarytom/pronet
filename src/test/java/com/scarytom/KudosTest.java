package com.scarytom;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;


public class KudosTest {

	@Test
	public void twoNodeGraph() {
		Programmer programmer2 = new Programmer("programmer2", Sets.<String>newHashSet());
		Programmer programmer = new Programmer("programmer1", Sets.<String>newHashSet());
	    programmer.addRecommendation(programmer2);
		// calculate the kudos..
		assertEquals(programmer.getKudos(), 1);
	}
	
	@Test
	public void test() {	
		Programmer a = new Programmer("programmer2", Sets.<String>newHashSet());
		Programmer b = new Programmer("programmer2", Sets.<String>newHashSet());
		Programmer c = new Programmer("programmer2", Sets.<String>newHashSet());
		Programmer d = new Programmer("programmer2", Sets.<String>newHashSet());
		
		a.addRecommendation(b);
		a.addRecommendation(c);
		b.addRecommendation(c);
		c.addRecommendation(a);
		d.addRecommendation(c);
		
//		A=1.49, B=0.78, C=1.59, D=0.15
		
		
		assertEquals(a.getKudos(), 1.49, 0.001);
		assertEquals(b.getKudos(), 0.78, 0.001);
		assertEquals(c.getKudos(), 1.59, 0.001);
		assertEquals(d.getKudos(), 0.15, 0.001);
	}
	
	

}
