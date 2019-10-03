package dev.andreghigo.katas.java.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

/**
 * Unit tests for {@link ZoneId}
 * 
 * an {@link ZoneId} represents the identity of a time-zone, which is used
 * to identify the rules to convert between {@link Instant} and a {@link LocalDateTime} 
 * 
 * @see ZoneId
 * 
 * @author andreghigo
 *
 */
public class ZoneIdTest {
	@Test
	public void of_passingValidZoneIds() {
		ZoneId zoneId = ZoneId.of("Z");
		String id = zoneId.getId();
		System.out.println(id);
	}
}
