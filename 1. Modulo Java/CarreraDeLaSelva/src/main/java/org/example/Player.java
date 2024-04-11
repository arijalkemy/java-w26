package org.example;

public class Player {
    private String dni, firstName, lastName, phone, emergencyContact, bloodType;
    private int age;
    public Player(String dni, String firstName, String lastName, String phone, String emergencyContact, String bloodType, int age) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.bloodType = bloodType;
        this.age = age;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
}
