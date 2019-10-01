package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * Unit tests for {@link LocalTime}
 * 
 * <p>LocalTime represents a time without a time-zone in the ISO-8601 calendar system
 * 
 * @author andreghigo
 */
public class LocalTimeTest {
	/**
	 * Testing valid string formats on LocalTime parsing.
	 * 
	 * <p><b>hh:mm</b>
	 * <p><b>hh:mm:ss</b>
	 * <p><b>hh:mm:ss.nnnnnnnnn</b>
	 * 
	 * <p><b>hh</b> - two digits for the hour-of-day (0-23). This is pre-padded by zero to ensure two digits
	 * a colon :
	 * 
	 * <p><b>mm</b> - two digits for the minute-of-hour (0-59). This is pre-padded by zero to ensure two digits.
	 * If the second-of-minute is zero or not available then the format is complete.
	 * 
	 * <p><b>ss</b> - two digits for the second-of-minute (0-59). This is pre-padded by zero to ensure two digits.
	 * If the nano-of-seconds is zero or not available then the format is complete.
	 * 
	 * <p><b>nnnnnnnnn</b> - one to nine digits for the nano-of-seconds (0-999999999). As many digits will be output as required.
	 * 
	 * @see LocalTime
	 * @see DateTimeFormatter#ISO_LOCAL_TIME
	 * 
	 */
	@Test
	public void parse_passingValidStringFormats() {
		LocalTime localTime = LocalTime.parse("00:00");
		assertEquals(00, localTime.getHour());
		assertEquals(00, localTime.getMinute());

		localTime = LocalTime.parse("23:59");
		assertEquals(23, localTime.getHour());
		assertEquals(59, localTime.getMinute());
		
		localTime = LocalTime.parse("00:00:00");
		assertEquals(00, localTime.getHour());
		assertEquals(00, localTime.getMinute());
		
		localTime = LocalTime.parse("23:59:59");
		assertEquals(23, localTime.getHour());
		assertEquals(59, localTime.getMinute());
		assertEquals(59, localTime.getSecond());
		
		localTime = LocalTime.parse("00:00:00.0");
		assertEquals(0, localTime.getHour());
		assertEquals(0, localTime.getMinute());
		assertEquals(0, localTime.getSecond());
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.00");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.000");
		assertEquals(0, localTime.getNano());

		localTime = LocalTime.parse("00:00:00.0000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.00000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.000000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.0000000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.00000000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("00:00:00.000000000");
		assertEquals(0, localTime.getNano());
		
		localTime = LocalTime.parse("23:59:59.999999999");
		assertEquals(23, localTime.getHour());
		assertEquals(59, localTime.getMinute());
		assertEquals(59, localTime.getSecond());
		assertEquals(999999999, localTime.getNano());
	}
	
	@Test
	public void testingPlayground() {
		int year = 2019;
		int month = 1;
		int dayOfMonth = 10;
		int hour = 23;
		int minute = 59;
		int second = 59;
		int nanoOfSecond = 999999999;
		
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		LocalTime time = LocalTime.of(hour, minute, second, nanoOfSecond);
		LocalDateTime localDateTime = LocalDateTime.of(date, time);
		ZoneId zone = ZoneId.of("UTC-3");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);
		Instant instant = Instant.ofEpochSecond(zonedDateTime.toEpochSecond());
		
		System.out.println("LocalTime = " + time);
		System.out.println("LocalDate = " + date);
		System.out.println("LocalDateTime = " + localDateTime);
		System.out.println("ZoneId = " + zone);
		System.out.println("ZonedDateTime = " + zonedDateTime);
		System.out.println("Instant = " + instant);
	}
}
