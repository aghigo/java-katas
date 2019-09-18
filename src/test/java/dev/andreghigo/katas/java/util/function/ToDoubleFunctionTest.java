package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.ToDoubleFunction;

import org.junit.Test;

public class ToDoubleFunctionTest {
	@Test
	public void applyAsDouble() {
		// The generic type is the parameter type, the return type is double
		ToDoubleFunction<String> convertStringToDouble = s -> Double.valueOf(s);
		
		// It is applyAsDouble with As in the middle, not apply, not applyToDouble, not applyDouble
		// has only one method. has not compose, andThen methods like in Function interface
		double result = convertStringToDouble.applyAsDouble("1");
		
		assertEquals(1.0, result, 0.001D);
	}
}
