package com.ejercicio.deportistas.models;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;

    public Person(String nombre, String apellido, int edad) {
        this.name = nombre;
        this.lastName = apellido;
        this.age = edad;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
