package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecommendationLetter")

public class RecommendationLetter {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "s_email")
	private String s_email;

	@Column(name = "p_email")
	private String p_email;

	public RecommendationLetter() {
		
	}

	public RecommendationLetter(int id, String text, String s_email, String p_email) {
		super();
		this.id = id;
		this.text = text;
		this.s_email = s_email;
		this.p_email = p_email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
		return "RecommendationLetter [id=" + id + ", text=" + text + ", s_email=" + s_email + ", p_email=" + p_email
				+ "]";
	}

}