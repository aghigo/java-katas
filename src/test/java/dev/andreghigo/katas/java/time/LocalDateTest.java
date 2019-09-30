package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * Unit tests for {@link LocalDate}
 * 
 * {@link LocalDate} represents a date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03.
 * 
 * @author andre.ghigo
 *
 */
public class LocalDateTest {
	/**
	 * Tests LocalDate parsing with valid formats (ISO-8601 local date format)
	 * 
	 * <p>yyyy-mm-dd
	 * 
	 * <p>Four digits or more for the year. Years in the range 0000 to 9999 will be pre-padded by zero to ensure four digits. Years outside that range will have a prefixed positive or negative symbol. 
	 * <p>A dash
	 * <p>Two digits for the month-of-year. This is pre-padded by zero to ensure two digits.
	 * <p>A dash
     * <p>Two digits for the day-of-month. This is pre-padded by zero to ensure two digits.
	 * 
	 * @see LocalDate
	 * @see DateTimeFormatter#ISO_LOCAL_DATE
	 */
	@Test
	public void parse_whenPassingValidStringFormats() {
		// Years outside the range will have a prefixed positive or negative symbol
		LocalDate localDate = LocalDate.parse("-0001-01-01");
		assertEquals(-1, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());

		// Years outside the range will have a prefixed positive or negative symbol
		localDate = LocalDate.parse("-10000-01-01");
		assertEquals(-10000, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		// Years in the range 1000 to 9999 will be pre-padded by zero to ensure four digits.
		localDate = LocalDate.parse("0001-01-01");
		assertEquals(1, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("9999-01-01");
		assertEquals(9999, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());

		// Years outside the range will have a prefixed positive or negative symbol
		localDate = LocalDate.parse("+00001-01-01");
		assertEquals(1, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		// Years outside the range will have a prefixed positive or negative symbol
		localDate = LocalDate.parse("+10000-01-01");
		assertEquals(10000, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-01-01");
		assertEquals(2019, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-12-01");
		assertEquals(2019, localDate.getYear());
		assertEquals(12, localDate.getMonthValue());
		assertEquals(1, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-01-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(01, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-02-28");
		assertEquals(2019, localDate.getYear());
		assertEquals(02, localDate.getMonthValue());
		assertEquals(28, localDate.getDayOfMonth());
		
		// February 29 in leap year
		localDate = LocalDate.parse("2016-02-29");
		assertEquals(2016, localDate.getYear());
		assertEquals(2, localDate.getMonthValue());
		assertEquals(29, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-03-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(3, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-04-30");
		assertEquals(2019, localDate.getYear());
		assertEquals(4, localDate.getMonthValue());
		assertEquals(30, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-05-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(5, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-06-30");
		assertEquals(2019, localDate.getYear());
		assertEquals(6, localDate.getMonthValue());
		assertEquals(30, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-07-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(7, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-08-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(8, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-09-30");
		assertEquals(2019, localDate.getYear());
		assertEquals(9, localDate.getMonthValue());
		assertEquals(30, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-10-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(10, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-11-30");
		assertEquals(2019, localDate.getYear());
		assertEquals(11, localDate.getMonthValue());
		assertEquals(30, localDate.getDayOfMonth());
		
		localDate = LocalDate.parse("2019-12-31");
		assertEquals(2019, localDate.getYear());
		assertEquals(12, localDate.getMonthValue());
		assertEquals(31, localDate.getDayOfMonth());
	}
}
