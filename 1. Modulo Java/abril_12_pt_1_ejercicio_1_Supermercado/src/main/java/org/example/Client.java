package org.example;

public class Client
{
    String name;
    String lastName;
    String dni;
    public Client(String name, String lastnName, String dni){
        this.name = name;
        this.lastName = lastnName;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
