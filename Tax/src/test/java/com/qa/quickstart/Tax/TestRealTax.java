package com.qa.quickstart.Tax;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class TestRealTax {

	@Parameters
	public static List<Double[]> data(){
			return Arrays.asList(new Double[][] {{-1d,0d},{0d,0d},{14999d,14999d},{15000d,14999.9d},{19999d,19499d},{20000d,19499.85d},{29999d,27999d},{30000d,27999.8},{44999d,39999d},{45000d,39999.75}});
	}
	
	private double Input1;
	private double Expected;
	
	public TestRealTax(double input1, double expected) {
		Input1 = input1;
		Expected = expected;
	}
	
	@Test
	public void test() {
		RealTax tax = new RealTax();
		System.out.println(tax.calcNet(Input1));
		assertEquals(Expected, tax.calcNet(Input1),0);
		
	}
}