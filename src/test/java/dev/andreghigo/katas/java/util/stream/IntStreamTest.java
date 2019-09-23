package dev.andreghigo.katas.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class IntStreamTest {
	@Test
	public void rangeClosed_whenRangeClosedIsBetween1And10_thenSumShouldBe55() {
		IntStream closedRangeIntStream = IntStream.rangeClosed(1, 10);
		
		int sum = closedRangeIntStream.sum();
		
		assertEquals(55, sum);
	}
}
