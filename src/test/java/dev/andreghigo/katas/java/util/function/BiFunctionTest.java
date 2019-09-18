package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

/**
 * Unit tests for the functional interface {@link BiFunction}
 * 
 * @author andre.ghigo
 *
 */
public class BiFunctionTest {
	@Test
	public void apply() {
		// The last generic type (R) is the return type
		// The first two generic types (T, U) are the parameter types
		BiFunction<Double, Integer, Double> multiplyDoubleWithInteger = (x, y) -> x * y;
		
		double result = multiplyDoubleWithInteger.apply(2.5, 3);
		
		assertEquals(7.5, result, 0.001);
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNull() {
		BiFunction<Double, Integer, Double> multiplyDoubleWithInteger = (x, y) -> x * y;
		
		multiplyDoubleWithInteger.andThen(null);
	}
	
	@Test
	public void andThen() {
		BiFunction<Double, Integer, Double> multiplyDoubleWithInteger = (x, y) -> x * y;
		Function<Double, Double> multiplyByTwo = x -> x * 2;
		
		// Has only apply and andThen method, has not compose method in BiFunction
		// andThen compose BiFunction with Function! not BiFunction with another BiFunction
		// The parameter type of the function is the return type of the BiFunction
		// The return type of the composed BiFunction is the return type of the Function
		// (T t, U u) -> after.apply(apply(t, u));
		BiFunction<Double, Integer, Double> multiplyAndThenSumDoubleWithInteger = multiplyDoubleWithInteger.andThen(multiplyByTwo);
		
		double result = multiplyAndThenSumDoubleWithInteger.apply(2.5, 3);
		
		// First multiply 2.5 by 3 and then multiply by two
		assertEquals(15, result, 0.001);
	}
}
