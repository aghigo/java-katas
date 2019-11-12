package dev.andreghigo.katas.java.util.function.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.BiPredicate;

import org.junit.Test;

public class BiPredicateTest {
	@Test
	public void test() {
		BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equalsIgnoreCase(s2);
		BiPredicate<String, String> biPredicate2 = String::equalsIgnoreCase;
		
		assertTrue(biPredicate.test("a", "a"));
		assertFalse(biPredicate.test("a", "b"));
		
		assertTrue(biPredicate2.test("a", "a"));
		assertFalse(biPredicate2.test("a", "b"));
	}
}
