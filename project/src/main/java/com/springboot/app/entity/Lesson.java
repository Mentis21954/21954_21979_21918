package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lesson")

public class Lesson {
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "lesson_name")
	private String lesson_name;

	@Column(name = "semester")
	private String semester;
	
	@Column(name = "grade")
	private String grade;

	@Column(name = "p_email")
	private String p_email;

	public Lesson(int id, String lesson_name, String semester, String grade, String p_email) {
		super();
		this.id = id;
		this.lesson_name = lesson_name;
		this.semester = semester;
		this.grade = grade;
		this.p_email = p_email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", lesson_name=" + lesson_name + ", semester=" + semester + ", grade=" + grade
				+ ", p_email=" + p_email + "]";
	}
	

}
