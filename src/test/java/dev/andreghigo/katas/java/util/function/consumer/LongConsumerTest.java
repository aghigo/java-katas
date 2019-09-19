package dev.andreghigo.katas.java.util.function.consumer;

import java.util.function.LongConsumer;

import org.junit.Test;

public class LongConsumerTest {
	@Test
	public void accept() {
		LongConsumer printLongValue = System.out::println;
		
		printLongValue.accept(23434234234232L);
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNull() {
		LongConsumer printLongValue = System.out::println;
		
		printLongValue.andThen(null);
	}
	
	@Test
	public void andThen() {
		LongConsumer printLongValue = System.out::println;
		
		LongConsumer printLongValueMultipliedBy1000 = l -> System.out.println(l * 1000);
		
		LongConsumer printLongValueAndThenPrintMultipliedBy1000 = printLongValue.andThen(printLongValueMultipliedBy1000);
		
		printLongValueAndThenPrintMultipliedBy1000.accept(34);
	}
}
