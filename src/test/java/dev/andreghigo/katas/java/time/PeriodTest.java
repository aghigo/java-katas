package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.Period;

import org.junit.Test;

/**
 * Unit test for {@link Period}
 * 
 * @see Period
 * 
 * {@link Period} A date-based amount of time in the ISO-8601 calendar system, such as '2 years, 3 months and 4 days'.
 * 
 * @author andreghigo
 *
 */
public class PeriodTest {
	/**
	 * Testing parsing of period with valid string formats.
	 * 
	 * <p>which is based on the ISO-8601 period formats PnYnMnD and PnW.
	 * 
	 * <p>optionally starts with + or -
	 * <p>Starts with letter P, of period
	 * <p>Y - years
	 * <p>M - months
	 * <p>W - weeks
	 * <p>D - days
	 * <p>n - an integer number (can be positive or negative). The number must parse to an int.
	 * 
	 * <p>The leading plus/minus sign, and negative values for other units are not part of the ISO-8601 standard. In addition, ISO-8601 does not permit mixing between the PnYnMnD and PnW formats. 
	 * Any week-based input is multiplied by 7 and treated as a number of days.
	 * 
	 * @see Period
	 */
	@Test
	public void parse_passingValidStringFormats() {
		// 1 year, 2 months and 30 days
		Period period = Period.parse("P1Y2M30D");
		assertEquals(1, period.getYears());
		assertEquals(2, period.getMonths());
		assertEquals(30, period.getDays());
		
		// The letters can also be in lowercase
		period = Period.parse("p1y2m30d");
		assertEquals(1, period.getYears());
		assertEquals(2, period.getMonths());
		assertEquals(30, period.getDays());
		
		// Can have + positive suffix
		period = Period.parse("+P+1Y+2M+30D");
		assertEquals(1, period.getYears());
		assertEquals(2, period.getMonths());
		assertEquals(30, period.getDays());
		
		// Can have some negative and some positive values
		period = Period.parse("P-1Y-2M+30D");
		assertEquals(-1, period.getYears());
		assertEquals(-2, period.getMonths());
		assertEquals(30, period.getDays());
		
		// If starts with - negative before P, all values are negatives
		period = Period.parse("-P1Y2M30D");
		assertEquals(-1, period.getYears());
		assertEquals(-2, period.getMonths());
		assertEquals(-30, period.getDays());
		
		// If starts with - negative befeore P, but also has negative values, it becomes positive.
		period = Period.parse("-P-1Y2M30D");
		assertEquals(1, period.getYears());
		assertEquals(-2, period.getMonths());
		assertEquals(-30, period.getDays());
		
		// can mix weeks, must be placed between months and days
		// Any week-based input is multiplied by 7 and treated as a number of days.
		period = Period.parse("P1Y1M1W1D");
		assertEquals(1, period.getYears());
		assertEquals(1, period.getMonths());
		assertEquals(8, period.getDays());
	}
}
