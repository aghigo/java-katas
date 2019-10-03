package dev.andreghigo.katas.java.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class ZonedDateTimeTest {
	@Test
	public void testingDifferenceBetweenDurationAndPeriodWhenAddingOneDayConsideringDaylightSavingTime() {
		// A Period of one day is a conceptual day, maintaining local time and ignoring daylight saving change
		Period period = Period.ofDays(1);
		
		// A Duration of one day is always exactly 24 hours
		Duration duration = Duration.ofDays(1);
		ZoneId zoneId = ZoneId.of("America/New_York");
		LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 10, 12, 0);
		ZonedDateTime referenceTime = ZonedDateTime.of(localDateTime, zoneId);
		ZonedDateTime perPlusTime = referenceTime.plus(period);
		ZonedDateTime durPlusTime = referenceTime.plus(duration);
		
		// Period represent a day, and change only the date, keeps the time
		System.out.println(perPlusTime); // 2018-03-11T12:00-04:00[America/New_York]
		
		// Duration of 1 day represents 24 hours, changes the time, and with DST, moves 1 hour forward as well
		System.out.println(durPlusTime); // 2018-03-11T13:00-04:00[America/New_York]
	}
}
