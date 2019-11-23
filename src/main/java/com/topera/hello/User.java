package com.topera.hello;

public class User {

	private int age;
	private boolean isKid;

	public void prepare(int kidLimit) {
		isKid = age < kidLimit;
	}

	public boolean isKid() {
		return isKid;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
