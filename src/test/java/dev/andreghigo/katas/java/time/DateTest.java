package dev.andreghigo.katas.java.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

/**
 * Unit tests for {@link Date}
 * 
 * @author andreghigo
 *
 */
public class DateTest {
	@Test
	public void convertingDateToLocalDateTime() {
		Date date = new Date();
		
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		System.out.println(date);
		System.out.println(localDateTime);
	}

}
