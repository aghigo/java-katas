package dev.andreghigo.katas.java.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.FileSystems;

import org.junit.Test;

public class FileTest {
	/**
	 * Testing different ways to get path separator
	 * 
	 * <p>
	 * Path separator is commonly used in PATH and CLASSPATH environment variables
	 * to separate multiple paths in one string.
	 * 
	 * <p>
	 * ; in Windows and : in Linux and Unix like OS
	 * 
	 * <p>
	 * Do not get confused with file separator
	 * 
	 * <p>
	 * Examples:
	 * <ul>
	 * <li>C:\java\bin;C:\tomcat\bin</li>
	 * <li>/etc/java/bin:/etc/tomcat/bin</li>
	 * </ul>
	 */
	@Test
	public void howToGetPathSeparator() {
		String pathSeparator1 = File.pathSeparator;
		char pathSeparator2 = File.pathSeparatorChar;
		String pathSeparator3 = System.getProperty("path.separator");

		assertNotNull(pathSeparator1);
		assertFalse(pathSeparator1.isEmpty());
		assertTrue(pathSeparator1.equals(";") || pathSeparator1.equals(":"));
		assertEquals(pathSeparator1.charAt(0), pathSeparator2);
		assertEquals(pathSeparator1, pathSeparator3);
		assertEquals(pathSeparator2, pathSeparator3.charAt(0));
	}

	/**
	 * Testing different ways to get file separator
	 * 
	 * <p>
	 * \ in Windows and / in Linux and Unix like OS
	 * 
	 * <p>
	 * Do not get confused with path separator
	 * 
	 * <p>
	 * Examples:
	 * <ul>
	 * <li>C:\java\bin</li>
	 * <li>/etc/java/bin</li>
	 * </ul>
	 */
	@Test
	public void howToGetFileSeparator() {
		String separator1 = File.separator;
		String separator2 = System.getProperty("file.separator");
		String separator3 = FileSystems.getDefault().getSeparator();
		char separator4 = File.separatorChar;

		assertNotNull(separator1);
		assertFalse(separator1.isEmpty());
		assertTrue(separator1.equals("\\") || separator1.equals("/"));
		assertEquals(separator1, separator2);
		assertEquals(separator1, separator3);
		assertEquals(separator2, separator3);
		assertEquals(separator1.charAt(0), separator4);
	}
}
