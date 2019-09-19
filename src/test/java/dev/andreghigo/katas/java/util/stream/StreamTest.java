package dev.andreghigo.katas.java.util.stream;

import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	/**
	 * The peek method of interface Stream performs an action on each element of the stream 
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
	 */
	@Test
	public void map() {}
	
	@Test
	public void mapToInt() {}
	
	@Test
	public void mapToLong() {}
	
	@Test
	public void mapToDouble() {}
	
	
}
