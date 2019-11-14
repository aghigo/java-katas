package dev.andreghigo.katas.java.util.localization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * Unit tests for {@link ResourceBundle}
 * 
 * @see ResourceBundle
 * 
 * @author andre.ghigo
 *
 */
public class ResourceBundleTest {

	// ------------------- getBundle --------------------
	
	@Test
	public void propertyResourceBundle_passingPropertiesFile() throws IOException {
		PropertyResourceBundle bundle = new PropertyResourceBundle(new FileReader(new File("src/test/resources/ResourceBundle_en_US.properties")));
		
		Enumeration<String> enumeration = bundle.getKeys();
		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}
		
		assertEquals(1, properties.size());
		assertEquals("prop=test from ResourceBundle_en_US", properties.get(0));
		
		// Unknown name
		assertEquals(null, bundle.getBaseBundleName());
		
		// Unknown locale
		assertEquals(null, bundle.getLocale());
	}
	
	@Test
	public void getBundle_withBaseNameAndLocale_passingFullQualifiedNameOfListResourceBundle() {
		ResourceBundle bundle = ResourceBundle.getBundle("dev.andreghigo.katas.java.util.localization.ListResourceBundleClass", new Locale("en", "US"));
		Enumeration<String> enumeration = bundle.getKeys();

		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}

		assertEquals(1, properties.size());
		assertEquals("prop=test from ListResourceBundleClass_en_US extends ListResourceBundle", properties.get(0));
		assertEquals("dev.andreghigo.katas.java.util.localization.ListResourceBundleClass", bundle.getBaseBundleName());
		assertEquals("en_US", bundle.getLocale().toString());
	}
	
	/**
	 * When no full locale (language + region, e.g. en_US) is match, try to match only the language (e.g en)
	 */
	@Test
	public void getBundle_withBaseNameAndLocale_whenNoFullLocaleMatchTriesToMatchOnlyLanguage() {
		ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("fr", "FR"));
		Enumeration<String> enumeration = bundle.getKeys();

		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}

		assertEquals(1, properties.size());
		assertEquals("prop=test from ResourceBundle_fr", properties.get(0));
		assertEquals("ResourceBundle", bundle.getBaseBundleName());
		assertEquals("fr", bundle.getLocale().toString());
	}

	@Test
	public void getBundle_withBaseNameAndLocale_whenPropertiesFileLocaleMatch() {
		ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("en", "US"));
		Enumeration<String> enumeration = bundle.getKeys();

		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}

		assertEquals(1, properties.size());
		assertEquals("prop=test from ResourceBundle_en_US", properties.get(0));
		assertEquals("ResourceBundle", bundle.getBaseBundleName());
		assertEquals("en_US", bundle.getLocale().toString());
	}

	/**
	 * When bundle with the specified locale is not found, then it tries the system default locale. 
	 */
	@Test
	public void getBundle_withBaseNameAndLocale_whenLocaleDontMatchButSystemDefaultLocaleMatch() {
		Locale.setDefault(new Locale("pt", "BR"));
		
		ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("ja", "JP"));
		Enumeration<String> enumeration = bundle.getKeys();

		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}

		assertEquals(1, properties.size());
		assertEquals("prop=test from ResourceBundle_pt_BR", properties.get(0));
		assertEquals("ResourceBundle", bundle.getBaseBundleName());
		assertEquals("pt_BR", bundle.getLocale().toString());
	}

	/**
	 * When the specified locale and system default locale bundles are not found, it finds the default file, with only the base name, without locale suffix.
	 * 
	 */
	@Test
	public void getBundle_withBaseNameAndLocale_whenPropertiesFileLocaleDoesNotMatch() {
		ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle2", new Locale("ja", "JP"));
		Enumeration<String> enumeration = bundle.getKeys();

		List<String> properties = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = bundle.getString(key);
			properties.add(key + "=" + value);
		}

		assertEquals(1, properties.size());
		assertEquals("prop=test from ResourceBundle2", properties.get(0));
		assertEquals("ResourceBundle2", bundle.getBaseBundleName());
		assertEquals("", bundle.getLocale().toString());
	}

	/**
	 * When no resource bundle is found, then it throws MissingResourceException
	 * 
	 * @see MissingResourceException
	 * 
	 */
	@Test
	public void getBundle_withBaseNameAndLocale_whenNoResourceIsFound() {
		String baseName = "XXX";
		Locale locale = new Locale("ja", "JP");
		try {
			ResourceBundle.getBundle(baseName, locale);
			fail("Should throw MissingResourceException");
		} catch (MissingResourceException e) {
			assertEquals("Can't find bundle for base name " + baseName + ", locale " + locale.toString(), e.getMessage());
		}
	}
}
