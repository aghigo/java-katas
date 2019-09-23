package dev.andreghigo.katas.java.util.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	/**	
	 * The peek method of interface Stream performs an action on each element of the stream
	 * 
	 * peek is a intermediate operation
	 * 
	 */
	@Test
	public void peek() {
		class Person {
			private String name;
			private int age;
			Person(String name, int age) {
				this.name = name;
				this.age = age;
			}
			public String getName() { return name; }
			public int getAge() { return age; }
		}
		
		Person logan = new Person("Logan", 25);
		Person avery = new Person("Avery", 22);
		
		Stream<Person> stream1 = Stream.of(logan, avery);
		
		// peek is an intermediate operation, so it does nothing until a terminal operator is triggered
		Stream<Person> stream2 = stream1.peek(p -> System.out.println(p.getName() + ": " + p.getAge()));
		
		// forEach is a terminal operator, in this case it does nothing, but it triggers the intermediate operations
		stream2.forEach(p -> {});
	}
	
	/**
	 * The map method of interface Stream applies a mapper to elements of the stream; this method has three
	 * primitive type specializations (mapToInt, mapToLong, mapToDouble)
	 * 
	 * map is an intermediate operation
	 * 
	 */
	@Test
	public void map() {
		Stream<String> stream = Stream.of("2", "z", "A");
		
		// for each value of the stream, apply a 'transformation' on each element of the stream,
		// get the new value and append in a new stream, the new stream
		// contains all the new values derived from the previous one.
		List<String> values = stream
				.map(x -> x + "ABC")
				.collect(Collectors.toList());
		
		assertEquals("2ABC", values.get(0));
		assertEquals("zABC", values.get(1));
		assertEquals("AABC", values.get(2));
	}
	
	@Test
	public void findFirst() {
		Stream<String> stream = Stream.of();
		
		Optional<String> optional = stream.findFirst();
		
		assertFalse(optional.isPresent());
		
		stream = Stream.of("34", "43");
		
		optional = stream.findFirst();
		
		assertTrue(optional.isPresent());
		
		assertEquals("34", optional.get());
	}
	
	@Test
	public void findAny() {
		// When stream is empty
		
		// When not found
		
		// When found
	}
	
	@Test
	public void anyMatch() {
		// When stream is empty
		
		// When not found
		
		// When found
	}
	
	@Test
	public void allMatch() {
		// When stream is empty
		
		// When not found
		
		// When found
	}
	
	@Test
	public void noneMatch() {
		// When stream is empty
		
		// When not found
		
		// When found
	}
	
	@Test
	public void iterate() {
		Stream<Integer> numbers = Stream.iterate(0, x -> x + 1);
		
		numbers.limit(10).forEach(System.out::println);
	}
	
	@Test
	public void generate() {
		Stream<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt());
		
		randomNumbers.limit(Long.MAX_VALUE).forEach(System.out::println);
	}
	
	@Test
	public void performMulitpleTerminalOperationsInTheSameStream() {
		
	}
	
	@Test
	public void limit_whenLimitedToHalfSize_shouldReturnOnlyFirstHalfElements() {
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		List<Integer> result = integerStream.limit(5).collect(Collectors.toList());
		
		assertEquals(5, result.size());
		assertEquals(1, result.get(0).intValue());
		assertEquals(2, result.get(1).intValue());
		assertEquals(3, result.get(2).intValue());
		assertEquals(4, result.get(3).intValue());
		assertEquals(5, result.get(4).intValue());
	}
}
