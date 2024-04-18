package org.example;

public abstract class Animal {
    private String nombre;
    private String raza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Animal(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    public abstract void emitirSonido();

    public abstract void comerAnimal();
}
