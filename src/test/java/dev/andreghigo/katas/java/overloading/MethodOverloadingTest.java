package dev.andreghigo.katas.java.overloading;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MethodOverloadingTest {
	public String test(String a) {
		return "test(String a)";
	}
	
	public String test(CharSequence a) {
		return "test(CharSequence a)";
	}
	
	public String test(int a) {
		return "test(int a)";
	}
	
	public String test(long a) {
		return "test(long a)";
	}
	
	public String test(Integer a) {
		return "test(Integer a)";
	}
	
	public String test(long ...a) {
		return "test(long ...a)";
	}
	
	@Test
	public void testOverloadingOrder() {
		assertEquals("test(String a)", this.test("test"));
		assertEquals("test(int a)", this.test(1));
	}
}
