package dev.andreghigo.katas.java.util.function.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

/**
 * Unit tests for {@link java.util.function.Predicate} use cases
 * 
 * @author andreghigo
 *
 */
public class PredicateTest {
	@Test
	public void test() {
		Predicate<Integer> isEven = x -> x % 2 == 0;
		
		assertTrue(isEven.test(2));
		assertFalse(isEven.test(3));
	}
	
	@Test
	public void negate() {
		Predicate<Integer> isEven = x -> x % 2 == 0;
		
		Predicate<Integer> isNotEven = isEven.negate();
		
		assertFalse(isNotEven.test(2));
		assertTrue(isNotEven.test(3));
	}
	
	@Test
	public void and() {
		Predicate<Integer> isDivisibleByTwo = x -> x % 2 == 0;
		Predicate<Integer> isDivisibleByFive = x -> x % 5 == 0;
		
		Predicate<Integer> isDivisibleByTwoAndFive = isDivisibleByTwo.and(isDivisibleByFive);
		
		assertTrue(isDivisibleByTwo.test(2));
		assertFalse(isDivisibleByFive.test(2));
		assertFalse(isDivisibleByTwoAndFive.test(2));
		
		assertTrue(isDivisibleByFive.test(5));
		assertFalse(isDivisibleByTwo.test(5));
		assertFalse(isDivisibleByTwoAndFive.test(5));
		
		assertTrue(isDivisibleByTwo.test(50));
		assertTrue(isDivisibleByFive.test(50));
		assertTrue(isDivisibleByTwoAndFive.test(50));
	}
	
	@Test
	public void or() {
		Predicate<Integer> isEven = x -> x % 2 == 0;
		Predicate<Integer> isOdd = x -> x % 2 != 0;
		
		Predicate<Integer> isEvenOrOdd = isEven.or(isOdd);
		
		assertTrue(isEven.test(4));
		assertFalse(isOdd.test(4));
		assertTrue(isEvenOrOdd.test(4));
		
		assertTrue(isOdd.test(3));
		assertFalse(isEven.test(3));
		assertTrue(isEvenOrOdd.test(3));
	}
	
	@Test
	public void isEqual() {
		Predicate<Integer> isEqual = Predicate.isEqual(1);
		
		assertFalse(isEqual.test(2));
		assertTrue(isEqual.test(1));
	}
	
	@Test
	public void isEqualWhenPassingNull() {
		Predicate<Integer> isEqual = Predicate.isEqual(null);
		
		assertTrue(isEqual.test(null));
		assertFalse(isEqual.test(1));
	}
}
