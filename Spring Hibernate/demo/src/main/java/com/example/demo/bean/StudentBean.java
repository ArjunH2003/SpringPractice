package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Student112")
public class StudentBean {

    @Id
    @GeneratedValue
    private int sid;

    @Column
    private String name;

    @Column
    private String email;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentBean [sid=" + sid + ", name=" + name + ", email=" + email + "]";
    }

    

    
}