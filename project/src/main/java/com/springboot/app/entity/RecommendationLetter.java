package com.springboot.app.entity;

import com.springboot.app.entity.Request;
import com.springboot.app.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "RecommendationLetter")
public class RecommendationLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false, length = 200)
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_email", nullable = false)
    private User teacherEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public User getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(User teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}