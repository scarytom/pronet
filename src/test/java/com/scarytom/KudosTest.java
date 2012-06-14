package com.scarytom;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.scarytom.pronet.Programmer;


public class KudosTest {

	@Test
	public void test() {
		Programmer programmer2 = new Programmer("programmer2", Collections.<Programmer>emptySet());
		Set<Programmer> recommendations = new HashSet();
		recommendations.add(programmer2);
		Programmer programmer = new Programmer("programmer1", recommendations);
	}

}
