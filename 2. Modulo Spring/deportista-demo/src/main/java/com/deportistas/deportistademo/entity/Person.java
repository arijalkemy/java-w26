package com.deportistas.deportistademo.entity;

public class Person {
   private String name;
   private String surname;
   private Integer age;
   private Sport sport;

    public Person(String name, String surname, Integer age, Sport sport) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sport=" + sport +
                '}';
    }
}
