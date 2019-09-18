package dev.andreghigo.katas.java.util.function.consumer;

import java.util.function.Consumer;

import org.junit.Test;

/**
 * Unit test for the function interface {@link java.util.function.Consumer} use cases
 * 
 * @author andreghigo
 *
 */
public class ConsumerTest {
	@Test
	public void accept() {
		Consumer<String> printHelloWorld = x -> System.out.println("Hello World, " + x);
		
		printHelloWorld.accept("John Doe");
	}
	
	@Test(expected = NullPointerException.class)
	public void andThenWhenPassingNullParameterShouldThrowNullPointerException() {
		Consumer<String> printHelloWorld = x -> System.out.println("Hello World, " + x);
		
		printHelloWorld.andThen(null);
	}
	
	@Test
	public void andThen() {
		Consumer<String> printHelloWorld = x -> System.out.println("Hello World, " + x);
		
		Consumer<String> printGreetings = x -> System.out.println("Greetings, " + x);
		
		Consumer<String> printHelloWorldAndThenPrintGreetings = printHelloWorld.andThen(printGreetings);
		
		printHelloWorldAndThenPrintGreetings.accept("John Doe");
	}
}
