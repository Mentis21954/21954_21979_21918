package com.springboot.app.Entity;

import javax.persistence.*;

@Entity
@Table(name = "RecommendationLetter")
public class RecommendationLetter {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "text", nullable = false, length = 200)
    private String text;

    @Column(name = "teacher_email", nullable = false, length = 45)
    private String teacher_email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", nullable = false)
    private Request requests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }
}
