package org.example.ejerciciodeportistas.models;

public class Person {
    private String name;
    private String lastname;
    private int age;
    private Sport sport;

    public Person(String name, String lastname, int age, Sport sport) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sport = sport;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
