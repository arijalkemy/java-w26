package com.example.ejerciciodeportistas.clases;

public class Deportista extends Persona {
    Deporte deporte;
    public Deportista(String nombre, String apellido, int edad, Deporte deporte) {
        super(nombre, apellido, edad);
        this.deporte = deporte;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
}
