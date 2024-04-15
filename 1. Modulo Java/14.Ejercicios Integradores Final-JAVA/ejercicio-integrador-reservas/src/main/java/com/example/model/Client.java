package com.example.model;

public class Client {

    private String name;
    private String dni;
    private String email;

    public Client() {

    }

    public Client(String name, String dni, String email) {
        this.name = name;
        this.dni = dni;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "\n" +
                "-----------------------------------------------" + "\n" +
                "Nombre de cliente: " + this.getName() + "\n" +
                "DNI: " + this.getDni() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "-----------------------------------------------";

    }

}
