package com.jsondemo.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private int age;
    private Date registerDate;

    public Student() {
    }

    public Student(int id, String name, int age, Date registerDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
