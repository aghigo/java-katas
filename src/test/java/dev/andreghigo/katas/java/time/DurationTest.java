package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

import org.junit.Test;

/**
 * Unit tests for {@link Duration}
 * 
 * A {@link Duration} represents A time-based amount of time, such as '34.5 seconds'.
 * 
 * @see Duration
 * 
 * @author andreghigo
 *
 */
public class DurationTest {
	@Test
	public void getUnits_supportsOnlySecondsAndNano() {
		Duration duration = Duration.ofSeconds(1);
		
		List<TemporalUnit> temporalUnits = duration.getUnits();
		
		assertEquals(2, temporalUnits.size());
		assertEquals(ChronoUnit.SECONDS, temporalUnits.get(0));
		assertEquals(ChronoUnit.NANOS, temporalUnits.get(1));
	}
	
	@Test
	public void parse_passingValidStringFormats() {
		// Duration of 2 seconds
		Duration duration = Duration.parse("PT2S");
		assertEquals(2, duration.getSeconds());
		assertEquals(0, duration.getNano());
		
		// Duration of 2 seconds and 1 nanosecond
		// use . after seconds to get nano seconds
		duration = Duration.parse("PT2.000000001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(1, duration.getNano());
		
		// Duration of 2 seconds and 1 nanoseconds
		// also can use , as separator
		duration = Duration.parse("PT2,000000001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(1, duration.getNano());
		
		// Duration of 2 seconds and 1 nanoseconds
		// The optional nano after separator may have from zero to 9 digits
		// Note: this is considered as the fractional part of the second, not the amount of nanoseconds
		// so 00000001 is 10 nanos
		duration = Duration.parse("PT2,00000001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(10, duration.getNano());
		
		// Note: this is considered as the fractional part of the second, not the amount of nanoseconds
		// so 0000001 is 100 nanos
		duration = Duration.parse("PT2,0000001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(100, duration.getNano());
		
		duration = Duration.parse("PT2,000001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(1000, duration.getNano());
		
		duration = Duration.parse("PT2,00001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(10000, duration.getNano());
		
		duration = Duration.parse("PT2,0001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(100000, duration.getNano());
		
		duration = Duration.parse("PT2,001S");
		assertEquals(2, duration.getSeconds());
		assertEquals(1000000, duration.getNano());
		
		duration = Duration.parse("PT2,01S");
		assertEquals(2, duration.getSeconds());
		assertEquals(10000000, duration.getNano());
		
		duration = Duration.parse("PT2,1S");
		assertEquals(2, duration.getSeconds());
		assertEquals(100000000, duration.getNano());
		
		// the factional part can have zero digits, with only the separator .
		duration = Duration.parse("PT2.S");
		assertEquals(2, duration.getSeconds());
		assertEquals(0, duration.getNano());
		
		// the factional part can have zero digits, with only the separator ,
		duration = Duration.parse("PT2,S");
		assertEquals(2, duration.getSeconds());
		assertEquals(0, duration.getNano());
	}

}
