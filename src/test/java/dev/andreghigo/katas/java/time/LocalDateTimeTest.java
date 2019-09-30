package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * Unit tests for {@link LocalDateTime}
 * 
 * @see LocalDateTime
 * 
 * <p> a LocalDateTime represents A date-time without a time-zone in the ISO-8601 calendar system
 * 
 * @author andreghigo
 * 
 */
public class LocalDateTimeTest {
	/**
	 * Testing parse, passing valid string formats.
	 * 
	 * <p>The format consists of:
	 * 
	 * <p>The {@link DateTimeFormatter#ISO_LOCAL_DATE ISO_LOCAL_DATE}
	 * <p>The letter 'T'. Parsing in case insensitive.
	 * <p>The {@link DateTimeFormatter#ISO_LOCAL_TIME ISO_LOCAL_TIME}
	 * 
	 * @see DateTimeFormatter#ISO_LOCAL_DATE_TIME
	 * @see DateTimeFormatter#ISO_LOCAL_DATE
	 * @see DateTimeFormatter#ISO_LOCAL_TIME
	 * 
	 */
	@Test
	public void parse_passingValidStringFormats() {
		// LocalDate format + 'T' + LocalTime format
		LocalDateTime localDateTime = LocalDateTime.parse("2019-12-31T00:00:00.000000000");
		assertEquals(2019, localDateTime.getYear());
		assertEquals(12, localDateTime.getMonthValue());
		assertEquals(31, localDateTime.getDayOfMonth());
		assertEquals(0, localDateTime.getHour());
		assertEquals(0, localDateTime.getMinute());
		assertEquals(0, localDateTime.getSecond());
		assertEquals(0, localDateTime.getNano());
		
		//The letter 'T' is parsed in case insensitive, so we can use 't' as well
		localDateTime = LocalDateTime.parse("2019-12-31t00:00:00.000000000");
		assertEquals(2019, localDateTime.getYear());
		assertEquals(12, localDateTime.getMonthValue());
		assertEquals(31, localDateTime.getDayOfMonth());
		assertEquals(0, localDateTime.getHour());
		assertEquals(0, localDateTime.getMinute());
		assertEquals(0, localDateTime.getSecond());
		assertEquals(0, localDateTime.getNano());
	}
}
