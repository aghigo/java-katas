package dev.andreghigo.katas.java.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitwiseOperatorsTest {
    @Test
    public void testBitwiseSignedLeftShift() {
    	// TODO
    }
	
	@Test
	public void testBitwiseSignedRightShift() {
		byte b = 4;
		assertEquals(0b100, b);
		assertEquals(0b001, b >>> 2);
	}
	
	@Test
	public void testBitwiseUnsignedRightShift() {}
	
    /**
     * Test the unary bitwise complement operator ~
     * 
     * The unary bitwise complement operator (~) inverts a bit pattern; it can be applied to any of the integral types, making every 0 a 1 and every 1 a 0.
     * 
     * Using the ~ operator inverts the number by change every '0' to '1' and every '1' to '0'
     * 
     */
    @Test
    public void testUnaryBitwiseComplementOperator() {
    	// '0b' or '0B' prefixed are needed to represent the literal in binary (Java 7+)
        // int has 32 bits in Java (4 bytes)
        // ~ can be used in byte, short int and long types
        // the ~ operator returns the result as int, so it needs downcasting for byte and short assignments
    	
        byte b = 8;
        assertEquals(0b1000, b);
        assertEquals(0b00000000000000000000000000001000, b);
        assertEquals(0b11111111111111111111111111110111, ~b);
        assertEquals(-9, ~b);
        
        short s = 8;
        assertEquals(0b1000, s);
        assertEquals(0b00000000000000000000000000001000, s);
        assertEquals(0b11111111111111111111111111110111, ~s);
        assertEquals(-9, ~s);
        
        int i = 8;
        assertEquals(0b1000, i);
        assertEquals(0b00000000000000000000000000001000, i);
        assertEquals( 0b11111111111111111111111111110111, ~i);
        assertEquals(-9, ~i);
        
        long l = 8;     
        assertEquals(0b1000, l);
        assertEquals(0b00000000000000000000000000001000, l);
        assertEquals(0b11111111111111111111111111110111, ~l);
        assertEquals(-9, ~l);
    }
}
