package com.scarytom;

import java.util.Collections;

import junit.framework.Assert;

import org.junit.Test;

import com.scarytom.pronet.Programmer;

public class PrintoutTest {

	@Test
	public void testCanDescribeEmptyNetwork() {
		String result = new NetworkBuilder().build().printout();
		String header = "Programmer\tSkills\tRecommends";
		Assert.assertEquals(header, result);

	}

	@Test
	public void testCanDescribeSingleNodeNetwork() {
		Programmer programmer = new Programmer("Bill", Collections.EMPTY_SET);
		String result = new NetworkBuilder().withProgrammer(programmer).build()
				.printout();
		String header = "Programmer\tSkills\tRecommends";

		Assert.assertEquals(header, result);
	}
}
