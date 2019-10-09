package dev.andreghigo.katas.java.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

/**
 * Unit tests for {@link Instant}
 * 
 * @see Instant
 * 
 * an {@link Instant} represents an instantaneous point on the time-line.
 * 
 * @author andreghigo
 *
 */
public class InstantTest {
	@Test
	public void convertInstantToLocalDateTime() {
		Instant instant = Instant.now();
		
		LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		System.out.println(instant);
		System.out.println(localDateTime);
	}
}
