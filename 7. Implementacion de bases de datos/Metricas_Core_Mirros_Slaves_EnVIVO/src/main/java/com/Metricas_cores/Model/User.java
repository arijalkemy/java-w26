package com.Metricas_cores.Model;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String name;
    private String lastname;
    private String gender;
    private LocalDate date;

    public User(Integer id, String name, String lastname, String gender, LocalDate date) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.date = date;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
