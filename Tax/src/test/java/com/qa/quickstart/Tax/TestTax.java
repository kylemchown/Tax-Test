package com.qa.quickstart.Tax;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class TestTax {

	@Parameters
	public static List<Double[]> data(){
			return Arrays.asList(new Double[][] {{-1d,0d},{0d,0d},{14999d,14999d},{15000d,13500d},{19999d,17999.1},{20000d,17000d},{29999d,25499.15},{30000d,24000d},{44999d,35999.2},{45000d,33750d}});
	}
	
	private double Input1;
	private double Expected;
	
	public TestTax(double input1, double expected) {
		Input1 = input1;
		Expected = expected;
	}
	
	@Test
	public void test() {
		Tax tax = new Tax();
		System.out.println(tax.calcNet(Input1));
		assertEquals(Expected, tax.calcNet(Input1), 0.01);
		
	}
}
