package com.company;

public class Person {
    private static int nextId = 1;
    private int id;
    private int dni;
    private String name;
    private String surname;
    private int age;
    private int phone;
    private int emergencyNumber;
    private String bloodType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(int emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Person(int dni, String name, String surname, int age, int phone, int emergencyNumber, String bloodType) {
        this.id = nextId;
        nextId++;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", emergencyNumber=" + emergencyNumber +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
