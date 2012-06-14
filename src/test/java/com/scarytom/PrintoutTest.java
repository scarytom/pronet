package com.scarytom;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.collect.Sets;
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
		Programmer bill = new Programmer("Bill", new HashSet<Programmer>());
		Programmer mary = new Programmer("Mary", Sets.newHashSet(bill));
		Programmer luke = new Programmer("Luke", Sets.newHashSet(bill));
		bill.addRecommendation(mary);
		bill.addRecommendation(luke);

		String result = new NetworkBuilder().withProgrammer(bill)
				.withProgrammer(luke).withProgrammer(mary).build().printout();
		Assert.assertEquals(HEADER + "\n" + "Bill\t\tMary, Luke" + "\n"
				+ "Mary\t\tBill" + "\n" + "Luke\t\tBill", result);
	}
}
