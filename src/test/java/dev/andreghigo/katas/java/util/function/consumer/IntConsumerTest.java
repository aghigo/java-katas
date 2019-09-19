package dev.andreghigo.katas.java.util.function.consumer;

import java.util.function.IntConsumer;

import org.junit.Test;

public class IntConsumerTest {
	@Test
	public void accept() {
		IntConsumer printIntValue = System.out::println;
		
		printIntValue.accept(2);
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNull() {
		IntConsumer printIntValue = System.out::println;
		
		printIntValue.andThen(null);
	}
	
	@Test
	public void andThen() {
		IntConsumer printIntValue = System.out::println;
		IntConsumer printIntValueMultipliedByFive = i -> System.out.println(i * 5);
		
		IntConsumer printValueAndThenPrintMultipliedByFive = printIntValue.andThen(printIntValueMultipliedByFive);
		
		printValueAndThenPrintMultipliedByFive.accept(5);
	}
}
