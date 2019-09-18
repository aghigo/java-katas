package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.ToLongFunction;

import org.junit.Test;

public class ToLongFunctionTest {
	@Test
	public void applyAsLong() {
		// the generic type is the parameter type
		ToLongFunction<String> convertStringToLong = s -> Long.valueOf(s);
		
		// has only one method, has not andThen nor compose methods like Function interface
		// it is applyAsLong with As! not apply, not applyToLong, not applyLong
		long result = convertStringToLong.applyAsLong("23");
		
		assertEquals(23L, result);
	}
}
