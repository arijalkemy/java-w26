package com.example.ejerciciodeportistas.DTO;

public class DeportistaDto {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "DeportistaDto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }
}
