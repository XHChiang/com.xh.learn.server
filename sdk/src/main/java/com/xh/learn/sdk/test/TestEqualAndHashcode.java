package com.xh.learn.sdk.test;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class TestEqualAndHashcode {
	private int id;
	private String name;

	public TestEqualAndHashcode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public static void main(String[] args) {
		TestEqualAndHashcode a1 = new TestEqualAndHashcode(1, "a");
		TestEqualAndHashcode b2 = new TestEqualAndHashcode(2, "b");
		TestEqualAndHashcode eb = new TestEqualAndHashcode(2, "b");

		System.out.println(a1.equals(b2));
		System.out.println(b2.equals(eb));
	}
}
