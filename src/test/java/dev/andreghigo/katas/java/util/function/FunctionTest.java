package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

/**
 * Unit test for the function interface {@link java.util.function.Function} use cases
 * 
 * @author andreghigo
 *
 */
public class FunctionTest {
	@Test
	public void apply() {
		// The return type is the last generic type (the second in this case)
		Function<Integer, Integer> incrementByOne = x -> x + 1;
		
		final int x = 5;
		
		int y = incrementByOne.apply(x);
		
		assertEquals(x + 1, y);
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNull() {
		Function<Integer, Integer> incrementByOne = x -> x + 1;
		
		incrementByOne.andThen(null);
	}
	
	@Test
	public void andThen() {
		Function<Integer, String> before = x -> "test " + x;
		Function<String, Integer> after = x -> 1;
		
		Function<Integer, Integer> andThen = before.andThen(after);
		
		int result = andThen.apply(3);
		
		assertEquals(1, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void composeWhenPassingNull() {
		Function<Integer, Integer> incrementByOne = x -> x + 1;
		
		incrementByOne.compose(null);
	}
	
	@Test
	public void compose() {
		Function<Integer, String> before = x -> "test " + x;
		Function<String, Integer> after = x -> 1;
		
		Function<Integer, Integer> composed = after.compose(before);
		
		int result = composed.apply(1);
		
		assertEquals(1, result);
	}
	
	@Test
	public void identity() {
		Function<String, String> identity = Function.identity();
		
		final String value = "e";
		
		String result = identity.apply(value);
		
		assertEquals(value, result);
	}
}
