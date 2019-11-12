package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.ToIntFunction;

import org.junit.Test;

public class ToIntFunctionTest {
	@Test
	public void applyAsInt() {
		// The generic type is the argument type, the return type is int
		// Has only applyToInt method, doesn't not have compose, andThen etc.
		// It is applyAsInt, not apply, not applyToInt 
		ToIntFunction<String> convertStringToInt = s -> Integer.valueOf(s);
		
		int result = convertStringToInt.applyAsInt("123");
		
		assertEquals(123, result);
	}
}
