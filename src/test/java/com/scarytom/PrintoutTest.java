package com.scarytom;

import junit.framework.Assert;

import org.junit.Test;

public class PrintoutTest {

	@Test
	public void testCanDescribeEmptyNetwork() {
		String result = new NetworkBuilder().build().printout();
		String header = "Programmer\tSkills\tRecommends";
		Assert.assertEquals(header, result);

	}

	@Test
	public void testCanDescribeSingleNodeNetwork() {
		String result = new NetworkBuilder().withProgrammer().build()
				.printout();
		String header = "Programmer\tSkills\tRecommends";

		Assert.assertEquals(header, result);
	}

}
