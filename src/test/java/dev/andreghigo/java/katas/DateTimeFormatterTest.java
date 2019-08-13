package dev.andreghigo.java.katas;

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
     * {@link https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE}
     * 
     */
    @Test
    public void ISO_DATE_formats() {
        LocalDate dt = LocalDate.of(2019, 3, 10);
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        assertEquals("2019-03-10", dt.format(dtf));
        
        LocalTime time = LocalTime.of(23, 45, 59);
        LocalDateTime ldt = LocalDateTime.of(dt, time);
        assertEquals("2019-03-10T23:45:59", ldt.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
