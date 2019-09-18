package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.LongFunction;

import org.junit.Test;

public class LongFunctionTest {
	@Test
	public void apply() {
		// the generic type is the return type
		LongFunction<String> convertLongToString = l -> Long.toString(l);
		
		// the method is apply, has not applyAsLong like ToLongFunction
		// has only one method, has not andThen or compose methods like Function
		String result = convertLongToString.apply(2L);
		
		assertEquals("2", result);
	}
}
