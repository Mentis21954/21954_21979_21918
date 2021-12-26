package com.springboot.app.entity;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Grade", nullable = false)
    private Integer grade;

    @Column(name = "Semester", nullable = false)
    private Integer semester;

    @Id
    @Column(name = "request_id", nullable = false)
    private Integer request_id;

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer id1) {
        this.request_id = request_id;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
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