package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.IntFunction;

import org.junit.Test;

public class IntFunctionTest {
	@Test
	public void apply() {
		// IntFunction -> function that returns int value
		// Specialization of the Function interface for int primitive type
		// The Generic type is the return type
		// IntFunction only has apply method, does not have compose, andThen methods.
		IntFunction<Double> covertIntToDouble = x -> Double.valueOf(x);
		
		Double result = covertIntToDouble.apply(5);
		
		assertEquals(5.0D, result.doubleValue(), 0.001);
	}
}
