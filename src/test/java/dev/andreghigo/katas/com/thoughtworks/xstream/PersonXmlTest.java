package dev.andreghigo.katas.com.thoughtworks.xstream;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import dev.andreghigo.katas.com.thoughtworks.xstream.PersonXml;

public class PersonXmlTest {
	private XStream xStream;
	
	@Before
	public void setUpXStream() {
		xStream = new XStream();
		xStream.processAnnotations(PersonXml.class);
	}
	
	@Test
	public void marshalPersonXmlObjectUsingXStream() {
		// GIVEN
		final String name = "Test";
		final int age = 22;
		
		PersonXml personXml = new PersonXml(name, age);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<person>\n");
		sb.append("  <name>").append(name).append("</name>\n");
		sb.append("  <age>").append(age).append("</age>\n");
		sb.append("</person>");
		
		final String expectedXml = sb.toString();
		
		// WHEN
		final String resultXml = xStream.toXML(personXml);
		
		// THEN
		assertEquals(expectedXml, resultXml);	
	}
	
	@Test
	public void unmarshalXmlToPersonXmlObjectUsingXStream() {
		// GIVEN
		final String name = "Test";
		final int age = 22; 
		
		StringBuilder sb = new StringBuilder();
		sb.append("<person>\n");
		sb.append("  <name>").append(name).append("</name>\n");
		sb.append("  <age>").append(age).append("</age>\n");
		sb.append("</person>");
		
		final String originalXml = sb.toString();
		
		// WHEN
		final PersonXml personXml = (PersonXml) xStream.fromXML(originalXml);
		
		// THEN
		assertEquals(name, personXml.getName());
		assertEquals(age, personXml.getAge());
	}
}
