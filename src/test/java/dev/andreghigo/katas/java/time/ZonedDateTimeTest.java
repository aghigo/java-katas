package dev.andreghigo.katas.java.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	
	@Test
	public void differenceBetweenWithZoneSameLocalAndWithZoneSameInstant() {
		LocalDate date = LocalDate.of(2019, 1, 1);
		LocalTime time = LocalTime.of(0, 0);
		
		ZoneId india = ZoneId.of("Asia/Kolkata");
		ZonedDateTime zIndia = ZonedDateTime.of(date, time, india);
		
		ZoneId us = ZoneId.of("America/Los_Angeles");
		
		// Returns a copy of this date-time with a different time-zone,retaining the local date-time if possible. 
		ZonedDateTime zUS = zIndia.withZoneSameLocal(us);
		System.out.println("zIndia  = " + zIndia);
		System.out.println("zIndia.toLocalDate()  = " + zIndia.toLocalDate());
		System.out.println("zIndia.toLocalTime()  = " + zIndia.toLocalTime());
		System.out.println("zIndia.toLocalDateTime()  = " + zIndia.toLocalDateTime());
		System.out.println("zIndia.withZoneSameLocal(us) = " + zUS);
				
		Duration durationBetweenIndiaAndUs = Duration.between(zIndia, zUS);
		System.out.println("duration = " + durationBetweenIndiaAndUs);
		
		// Returns a copy of this date-time with a different time-zone,retaining the instant
		// This method changes the time-zone and retains the instant.This normally results in a change to the local date-time. 
		ZonedDateTime zUS2 = zIndia.withZoneSameInstant(us);
		System.out.println("zIndia  = " + zIndia);
		System.out.println("zIndia.toLocalDate()  = " + zIndia.toLocalDate());
		System.out.println("zIndia.toLocalTime()  = " + zIndia.toLocalTime());
		System.out.println("zIndia.toLocalDateTime()  = " + zIndia.toLocalDateTime());
		System.out.println("zIndia.withZoneSameInstant(us) = " + zUS2);
		
		Duration durationBetweenIndiaAndUs2 = Duration.between(zIndia, zUS2);
		System.out.println("duration = " + durationBetweenIndiaAndUs2);
	}
}
