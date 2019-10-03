package dev.andreghigo.katas.java.time;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Test;

/**
 * Unit tests for {@link DateTimeFormatter}
 * 
 * @see DateTimeFormatter
 * 
 * @author andreghigo
 *
 */
public class DateTimeFormatterTest {
	/**
	 * Testing the pattern letter for era
	 * 
	 * <p>Symbol: G
	 * <p>Meaning: era
	 * <p>Presentation: text
	 * <p>Examples: AD; Anno Domini; A
	 * 
	 * @see DateTimeFormatter
	 */
	@Test
	public void ofPattern_whenPassingEraSymbolPatternLetters() {
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("G", Locale.ENGLISH);
		String text = date.format(formatter);
		System.out.println(text);
		assertEquals("AD", text);
		
		formatter = DateTimeFormatter.ofPattern("GG", Locale.ENGLISH);
		text = date.format(formatter);
		System.out.println(text);
		assertEquals("AD", text);
		
		formatter = DateTimeFormatter.ofPattern("GGG", Locale.ENGLISH);
		text = date.format(formatter);
		System.out.println(text);
		assertEquals("AD", text);
		
		formatter = DateTimeFormatter.ofPattern("GGGG", Locale.ENGLISH);
		text = date.format(formatter);
		System.out.println(text);
		assertEquals("Anno Domini", text);
		
		formatter = DateTimeFormatter.ofPattern("GGGGG", Locale.ENGLISH);
		text = date.format(formatter);
		System.out.println(text);
		assertEquals("A", text);
	}
	
	@Test
	public void ofPattern_whenPassingYearPatternLetters() {
		
	}
	
	@Test
	public void ofPattern_whenPassingYearOfEraPatternLetters() {
		
	}
}
