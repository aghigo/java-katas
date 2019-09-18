package dev.andreghigo.java.katas.function;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

/**
 * Unit tests for {@link java.util.function.Supplier}
 * 
 * @author andreghigo
 *
 */
public class SupplierTest {
	@Test
	public void get() {
		final String value = "test";
		
		Supplier<String> getValue = () -> value;
		
		assertEquals(value, getValue.get());
	}
}
