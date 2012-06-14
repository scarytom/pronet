package com.scarytom;

import java.util.HashSet;

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
		Programmer bill = new Programmer("Bill", new HashSet<String>());
		Programmer mary = new Programmer("Mary", new HashSet<String>());
		mary.addRecommendation(bill);
		Programmer luke = new Programmer("Luke", new HashSet<String>());
		luke.addRecommendation(bill);
		bill.addRecommendation(mary);
		bill.addRecommendation(luke);

		String result = new NetworkBuilder().withProgrammer(bill)
				.withProgrammer(luke).withProgrammer(mary).build().printout();
		Assert.assertEquals(HEADER

		+ "\n" + "Bill\t\tLuke, Mary"

		+ "\n" + "Luke\t\tBill"

		+ "\n" + "Mary\t\tBill"

		, result);
	}
}
