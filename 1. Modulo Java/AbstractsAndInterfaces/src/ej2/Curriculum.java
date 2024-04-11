package ej2;

import java.util.HashMap;
import java.util.List;

public class Curriculum extends DocumentoImpl{
    private String nombre;
    private String email;
    private int edad;
    private String dni;
    private List<String> habilidades;

    public Curriculum(String nombre, String email, int edad, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
