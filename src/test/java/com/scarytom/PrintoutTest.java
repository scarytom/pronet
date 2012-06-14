package com.scarytom;

import java.util.Collections;

import junit.framework.Assert;

import org.junit.Test;

import com.scarytom.pronet.Programmer;

public class PrintoutTest {

	String HEADER = "Programmer\tSkills\tRecommends";

	@Test
	public void testCanDescribeEmptyNetwork() {
		String result = new NetworkBuilder().build().printout();
		Assert.assertEquals(HEADER, result);

	}

	@Test
	public void testCanDescribeSingleNodeNetwork() {
		Programmer programmer = new Programmer("Bill", Collections.EMPTY_SET);
		String result = new NetworkBuilder().withProgrammer(programmer).build()
				.printout();

		Assert.assertEquals(HEADER + "\n" + "Bill\t\t", result);
	}
}
