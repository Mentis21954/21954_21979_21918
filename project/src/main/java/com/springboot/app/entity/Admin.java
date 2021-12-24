package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User{

	@Id
	@Column(name = "email")
	private int email;

	@Column(name = "password")
	private String password;

	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;


	public Admin(int email, String password, String fname, String lname) {
		super(email, password, fname, lname);
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		
	}
}
