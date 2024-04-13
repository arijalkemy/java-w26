package com.example.store;

public class Client {

    private String dni;
    private String name;
    private String lastName;

    public Client() {

    }

    public Client(String dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + "[ Nombre: " + this.getName() + " ]" +
                "[ Apellido: " + this.getLastName() + " ]" +
                "[ DNI: " + this.getDni() + " ]";

    }

}
