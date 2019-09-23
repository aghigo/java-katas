package dev.andreghigo.katas.java.util.random;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class RandomTest {
	@Test
	public void ints() {
		IntStream randomIntStream = new Random().ints();
	}
}
