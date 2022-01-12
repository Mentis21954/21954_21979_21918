package com.springboot.app.Entity;


import javax.persistence.*;

@Entity
@Table(name = "recommendationletter")
public class RecommendationLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id", nullable = false)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "requests_id", nullable = false)
    private Request requests;

    @Column(name = "text", nullable = false, length = 16383)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}