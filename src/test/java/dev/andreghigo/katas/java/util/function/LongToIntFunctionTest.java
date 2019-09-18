package dev.andreghigo.katas.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.function.LongToIntFunction;

import org.junit.Test;

public class LongToIntFunctionTest {
	@Test
	public void applyAsInt() {
		LongToIntFunction halfIntValue = l -> (int) l / 2;
		
		long value = 23L;
		
		int result = halfIntValue.applyAsInt(value);
		
		assertEquals(value / 2, result);
	}
}
