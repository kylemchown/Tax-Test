package com.qa.quickstart.initialTesting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class TestMultiply {

	@Parameters
	public static List<Double[]> data(){
			return Arrays.asList(new Double[][] {{1d,2d,2d},{4d,5d,20d},{0d,6d,0d},{0.5,1d,0.5},{-1d,5d,-5d},{2d,2d,4d},{0.5,-2d,-1d}});
	}
	
	private double Input1;
	private double Input2;
	private double Expected;
	
	public TestMultiply(double input1, double input2, double expected) {
		Input1 = input1;
		Input2 = input2;
		Expected = expected;
	}
	
	@Test
	public void test() {
		Multiply multiply = new Multiply();
		
		assertEquals(Expected, multiply.multi(Input1, Input2), 0.01);
		
	}
}
