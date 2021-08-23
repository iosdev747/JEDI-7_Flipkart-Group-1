
package com.flipkart.bean;

public abstract class User {
	private int userId;
	private String name;
	private String password;
	private Gender gender;
	private String address;

	public User(int userId, String name, String password, Gender gender, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
