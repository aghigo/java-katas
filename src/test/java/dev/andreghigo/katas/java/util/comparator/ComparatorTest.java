package dev.andreghigo.katas.java.util.comparator;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

public class ComparatorTest {
	@Test
	public void compare() {
		Comparator<Integer> intComparator = (i1, i2) -> i1 - i2;
		
		int result = intComparator.compare(10, 3);
		assertTrue(result > 0);
		assertTrue(result != 0);
		
		result = intComparator.compare(3, 10);
		assertTrue(result < 0);
		assertTrue(result != 0);
		
		result = intComparator.compare(10, 10);
		assertTrue(result == 0);
	}
}
