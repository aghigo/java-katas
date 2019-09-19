package dev.andreghigo.katas.java.util.function.consumer;

import java.util.function.DoubleConsumer;

import org.junit.Test;

public class DoubleConsumerTest {
	@Test
	public void accept() {
		DoubleConsumer printDoubleValue = System.out::println;
		
		printDoubleValue.accept(3.343);
	}
	
	@Test
	public void andThenWhenPassingNull() {
		DoubleConsumer printDoubleValue = System.out::println;
		
		printDoubleValue.andThen(null);
	}
	
	@Test
	public void andThen() {
		DoubleConsumer printDoubleValue = System.out::println;
		DoubleConsumer printDoubleValueDividedByPI = d -> System.out.println(d / Math.PI);
		
		DoubleConsumer printDoubleValueAndThenPrintDividedByPI = printDoubleValue.andThen(printDoubleValueDividedByPI);
		
		printDoubleValueAndThenPrintDividedByPI.accept(34.322354);
	}
}
