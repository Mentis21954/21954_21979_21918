package com.springboot.app.Entity;


import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @Column(name = "lesson_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "grade", nullable = false, length = 45)
    private String grade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "requests_id", nullable = false)
    private Request requests;

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}