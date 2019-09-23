package dev.andreghigo.katas.java.util.function.predicate;

import java.util.function.BiPredicate;

import org.junit.Test;

public class BiPredicateTest {
	@Test
	public void test() {
		BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equalsIgnoreCase(s2);
		BiPredicate<String, String> biPredicate2 = String::equalsIgnoreCase;	
	}
}
