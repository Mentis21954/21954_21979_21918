package com.springboot.app.Entity;

import com.springboot.app.Entity.Request;

import javax.persistence.*;

@Entity
@Table(name = "recommendationLetter")
public class RecommendationLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false)
    private Integer text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "requests_id", nullable = false)
    private Request requests;

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }

    public Integer getText() {
        return text;
    }

    public void setText(Integer text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}