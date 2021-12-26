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

    @ManyToOne
    @JoinColumn(name = "User_email")
    private User userEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_email", nullable = false)
    private User teacherEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_email", nullable = false)
    private User studentEmail;

    public User getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(User studentEmail) {
        this.studentEmail = studentEmail;
    }

    public User getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(User teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public User getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}