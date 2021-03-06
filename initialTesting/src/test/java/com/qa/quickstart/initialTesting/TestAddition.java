package com.qa.quickstart.initialTesting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class TestAddition {

	@Parameters
	public static List<Double[]> data(){
			return Arrays.asList(new Double[][] {{1d,2d,3d},{3d,4d,7d},{5d,-2d,3d},{1d,0.5,1.5},{2d,0d,2d},{-3d,1.5,-1.5},{0d,0d,0d}});
	}
	
	private double Input1;
	private double Input2;
	private double Expected;
	
	public TestAddition(double input1, double input2, double expected) {
		Input1 = input1;
		Input2 = input2;
		Expected = expected;
	}
	
	@Test
	public void test() {
		Addition addition = new Addition();
		
		assertEquals(Expected, addition.add(Input1, Input2), 0.01);
		
	}
}
