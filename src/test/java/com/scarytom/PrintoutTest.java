package com.scarytom;

import junit.framework.Assert;

import org.junit.Test;

public class PrintoutTest {

	@Test
	public void testCanDescribeNetwork() {
		String result = new Network().printout();
		Assert.assertEquals("", result);

	}

}
