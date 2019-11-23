package com.topera.hello;

public class User {

	private int age;
	private boolean isKid;

	public User(int age){
		this.age = age;
	}

	public void prepare(int kidLimit) {
		isKid = age < kidLimit;
	}

	public boolean isKid() {
		return isKid;
	}

}
