package dev.andreghigo.java.katas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JavaOperatorsTest {
    
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
        byte b = 8;
        assertEquals(b, 0b1000);
        assertEquals(b, 0b00000000000000000000000000001000);
        assertEquals(~b, 0b11111111111111111111111111110111);
        assertEquals(~b, -9);
        
        short s = 8;
        assertEquals(s, 0b1000);
        assertEquals(s, 0b00000000000000000000000000001000);
        assertEquals(~s, 0b11111111111111111111111111110111);
        assertEquals(~s, -9);
        
        int i = 8;
        assertEquals(i, 0b1000);
        assertEquals(i, 0b00000000000000000000000000001000);
        assertEquals(~i, 0b11111111111111111111111111110111);
        assertEquals(~i, -9);
        
        long l = 8;
        assertEquals(l, 0b1000);
        assertEquals(l, 0b00000000000000000000000000001000);
        assertEquals(~l, 0b11111111111111111111111111110111);
        assertEquals(~l, -9);
        
        // '0b' or '0B' prefixed are needed to represent the literal in binary (Java 7+)
        // int has 32 bits in Java
        // ~ can be used in byte, short int and long types
        // the ~ operator returns the result as int
    }
}
