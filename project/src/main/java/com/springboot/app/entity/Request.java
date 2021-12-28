package com.springboot.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    
    @Column(name = "situation", nullable = false, length = 20)
    private String situation;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_email", nullable = false)
    private User teacherEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_email", nullable = false)
    private User student_email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public User getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(User teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public User getStudent_email() {
		return student_email;
	}

	public void setStudent_email(User student_email) {
		this.student_email = student_email;
	}
    
}
