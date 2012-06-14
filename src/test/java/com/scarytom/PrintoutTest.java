package com.scarytom;

import junit.framework.Assert;

import org.junit.Test;

public class PrintoutTest {

	@Test
	public void testCanDescribeEmptyNetwork() {
		String result = new Network().printout();
		String header = "Programmer\tSkills\tRecommends";
		Assert.assertEquals(header, result);

	}

}
