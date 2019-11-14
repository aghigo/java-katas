package dev.andreghigo.katas.java.util.localization;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 * Unit testes for {@link Locale} class
 * 
 * "A Locale object represents a specific geographical, political, or cultural region."
 * 
 * @see Locale
 *
 * @author andre.ghigo
 *
 */
public class LocaleTest {
	
	/**
	 * Locale accepts invalid language and invalid region/country.
	 * 
	 * <p> it displays language language in lowercase and region/country in upper case, separated by underscore _
	 */
	@Test
	public void builder_passingInvalidLanguageAndInvalidRegion() {
		Locale locale = new Locale.Builder().setLanguage("XX").setRegion("bb").build();
		
		assertEquals("xx_BB", locale.toString());
	}
	
	/**
	 * Get the display name of a locale in a specific locale language (system default or given locale)
	 * 
	 * <p> Examples:
	 * 
	 * <p> en_US in en_US -> English (United States)
	 * <p> en_US in pt_BR -> Inglês (Estados Unidos)
	 * <p> en_US in it_IT -> inglese (Stati Uniti)
	 * <p> en_US in fr_FR -> anglais (Etats-Unis)
	 * <p> en_US in de_DE -> Englisch (Vereinigte Staaten von Amerika)
	 * 
	 */
	@Test
	public void displayName() {
		Locale.setDefault(new Locale("en", "US"));
		
		Locale locale = new Locale("en", "US");
		
		assertEquals("English (United States)", locale.getDisplayName());
		assertEquals("inglês (Estados Unidos)", locale.getDisplayName(new Locale("pt", "BR")));
		assertEquals("inglese (Stati Uniti)", locale.getDisplayName(new Locale("it", "IT")));
		assertEquals("anglais (Etats-Unis)", locale.getDisplayName(new Locale("fr", "FR")));
		assertEquals("Englisch (Vereinigte Staaten von Amerika)", locale.getDisplayName(new Locale("de", "DE")));
	}
	
	/**
	 * Displays a locale country name in a specific locale language (system default or other given locale language)
	 * 
	 * <p> Examples:
	 * 
	 * <p> it_IT in pt_BR -> Itália
	 * <p> it_IT in en_US -> Italy
	 * <p> it_IT in fr_FR -> Italie
	 */
	@Test
	public void displayCountry() {
		Locale.setDefault(new Locale("en", "US"));
		
		Locale locale = new Locale("it", "IT");
		
		// It will display the country of that locale in the default locale language
		// e.g. it_IT is Italy because default is en_US
		assertEquals("Italy", locale.getDisplayCountry());
		
		// It will display it_IT country in a provided Locale name, in this case fr_FR which is Italie
		assertEquals("Italie", locale.getDisplayCountry(Locale.FRANCE));
		
		// Display it_IT in Portuguese -> Itália
		assertEquals("Itália", locale.getDisplayCountry(new Locale("pt", "BR")));
	}
	
	/**
	 * Display a locale language name in a specific locale language (system default or other given locale language)
	 * 
	 * <p> Examples:
	 * 
	 * <p> it_IT in pt_BR -> italiano
	 * <p> it_IT in en_US -> Italian
	 * <p> it_IT in fr_FR -> italien
	 */
	@Test
	public void getDisplayLanguage() {
		Locale.setDefault(new Locale("en", "US"));
		
		Locale locale = new Locale("it", "IT");

		assertEquals("Italian", locale.getDisplayLanguage());
		assertEquals("italiano", locale.getDisplayLanguage(new Locale("pt", "BR")));
		assertEquals("italiano", locale.getDisplayLanguage(new Locale("it", "IT")));
		assertEquals("italien", locale.getDisplayLanguage(new Locale("fr", "FR")));
		assertEquals("Italienisch", locale.getDisplayLanguage(new Locale("de", "DE")));
	}
}
