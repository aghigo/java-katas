package dev.andreghigo.java.katas.function;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

/**
 * Unit test for {@link java.util.function.Function} interface methods
 * 
 * @author andreghigo
 *
 */
public class FunctionInterfaceTest {
	@Test
	public void apply() {
		Function<Integer, Integer> incrementByOne = x -> x + 1;
		
		final int x = 5;
		
		int y = incrementByOne.apply(x);
		
		assertEquals(x + 1, y);
	}
	
	@Test
	public void andThen() {
		Function<Integer, String> before = x -> "test " + x;
		Function<String, Integer> after = x -> 1;
		
		Function<Integer, Integer> andThen = before.andThen(after);
		
		int result = andThen.apply(3);
		
		assertEquals(1, result);
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
		
		String result = identity.apply("e");
		
		assertEquals("e", result);
	}
}
