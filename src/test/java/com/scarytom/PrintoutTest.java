package com.scarytom;

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
		Programmer bill = new Programmer("Bill", Sets.newHashSet("Java", "C#"));
		Programmer mary = new Programmer("Mary", Sets.newHashSet("COBOL", "C#",
				"Java"));
		mary.addRecommendation(bill);
		Programmer luke = new Programmer("Luke", Sets.newHashSet("Javascript",
				"Java"));
		luke.addRecommendation(bill);
		bill.addRecommendation(mary);
		bill.addRecommendation(luke);

		String result = new NetworkBuilder().withProgrammer(bill)
				.withProgrammer(luke).withProgrammer(mary).build().printout();
		Assert.assertEquals(HEADER

		+ "\n" + "Bill\tC#, Java\tLuke, Mary"

		+ "\n" + "Luke\tJava, Javascript\tBill"

		+ "\n" + "Mary\tC#, COBOL, Java\tBill"

		, result);
	}
}
