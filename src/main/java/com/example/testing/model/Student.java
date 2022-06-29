package com.example.testing.model;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private String address;
    
    public Student(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public Student() {
    }
    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
