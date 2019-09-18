package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.junit.Test;

public class UnaryOperatorTest {
	@Test
	public void apply() {
		UnaryOperator<String> selfConcat = s -> s + s;
		
		String value = "ABC";
		
		String result = selfConcat.apply(value);
		
		assertEquals("ABCABC", result);
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNull() {
		UnaryOperator<String> selfConcat = s -> s + s;
		
		selfConcat.andThen(null);
	}
	
	@Test
	public void andThen() {
		UnaryOperator<String> selfConcatTwice = s -> s + s;
		
		Function<String, String> concatDoubleThreeTimes = d -> d.toString() + d.toString() + d.toString();
		
		Function<String, String> selfConcatTwiceAndThenConcatDoubleThreeTimes = selfConcatTwice.andThen(concatDoubleThreeTimes);
		
		String result = selfConcatTwiceAndThenConcatDoubleThreeTimes.apply("3");
		
		assertEquals("333333", result);
	}
	
	@Test(expected = NullPointerException.class)
	public void composeWhenPassingNull() {
		UnaryOperator<String> selfConcat = s -> s + s;
		
		selfConcat.compose(null);
	}
	
	@Test
	public void compose() {
		UnaryOperator<String> selfConcatTwice = s -> s + s;
		
		Function<Double, String> concatDoubleThreeTimes = d -> d.toString() + d.toString() + d.toString();
		
		Function<Double, String> concatDoubleThreeTimesAndThenSelfConcatTwice = selfConcatTwice.compose(concatDoubleThreeTimes);
		
		String result = concatDoubleThreeTimesAndThenSelfConcatTwice.apply(3.0);
		
		assertEquals("3.03.03.03.03.03.0", result);
	}
	
	@Test
	public void identity() {
		UnaryOperator<String> identity = UnaryOperator.identity();
		
		String value = "test";
		
		String result = identity.apply(value);
		
		assertEquals(value, result);
	}
}
