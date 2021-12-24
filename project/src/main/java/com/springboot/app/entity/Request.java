package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Request")

public class Request {
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "situation")
	private String situation;

	@Column(name = "s_email")
	private String s_email;

	@Column(name = "p_email")
	private String p_email;

	public Request(int id, String situation, String s_email, String p_email) {
		super();
		this.id = id;
		this.situation = situation;
		this.s_email = s_email;
		this.p_email = p_email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", situation=" + situation + ", s_email=" + s_email + ", p_email=" + p_email + "]";
	}
	
	

}
