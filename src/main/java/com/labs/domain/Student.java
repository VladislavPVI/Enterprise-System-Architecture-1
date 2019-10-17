package com.labs.domain;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQuery(name = "Student.getAll", query = "SELECT u from Student u")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String fullname;

    public Student() {
    }

    public Student(String fullname, int age, String task_id) {
        this.fullname = fullname;
        this.age = age;
        this.task_id = task_id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    private String task_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }




}