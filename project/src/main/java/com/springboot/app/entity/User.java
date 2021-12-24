package com.springboot.app.entity;

public abstract class User {
	
	private int email;
	
	private String password;

	private String fname;
	
	private String lname;

	public User(int email, String password, String fname, String lname) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
