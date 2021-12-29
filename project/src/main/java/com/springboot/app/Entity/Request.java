package com.springboot.app.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Request")
public class Request {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "situation",nullable = false)
    private String situation;

    @Column(name = "teacher_email",nullable = false)
    private String teacher_email;

    @Column(name = "student_email",nullable = false)
    private String student_email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
