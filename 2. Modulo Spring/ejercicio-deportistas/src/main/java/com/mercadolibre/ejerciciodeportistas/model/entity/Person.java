package com.mercadolibre.ejerciciodeportistas.model.entity;

public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private Sport sport;
    public Person(String name, String lastName, Integer age, Sport sport) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
