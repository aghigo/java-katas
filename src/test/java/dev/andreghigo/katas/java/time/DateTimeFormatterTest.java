package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DateTimeFormatterTest {
    /**
     * Test acceptable formats for ISO_DATE from  {@link java.time.format.DateTimeFormatter}
     * 
     * YYYY-MM-DD
     *
     * {@link https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE}
     * 
     */
    @Test
    public void ISO_DATE_format() {
        LocalDate dt = LocalDate.of(2019, 3, 10);
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        assertEquals("2019-03-10", dt.format(dtf));
    }
    
    /**
     * Test acceptable formats for ISO_DATE from  {@link java.time.format.DateTimeFormatter}
     * 
     * YYYY-MM-DDTHH:MM:SS
     *
     * {@link https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE_TIME}
     * 
     */
    @Test
    public void ISO_DATE_TIME_format() {
        LocalDate localDate = LocalDate.of(2019, 3, 10);
        LocalTime localTime = LocalTime.of(23, 45, 59);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        assertEquals("2019-03-10T23:45:59", localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
