
package com.flipkart.bean;

public abstract class User {
	private int userId;
	private String name;
	private String password;
	private String address;

	public User(int userId, String name, String password, String address) {
		this.userId = userId;
		this.name = name;
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
