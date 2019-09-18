package dev.andreghigo.katas.com.thoughtworks.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public final class PersonXml {
	private final String name;
	private final int age;
	
	public PersonXml(final String name, final int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
