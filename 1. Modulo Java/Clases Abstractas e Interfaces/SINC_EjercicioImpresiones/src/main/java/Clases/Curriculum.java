package Clases;

import Interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, int dni, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.habilidades = habilidades;
    }

    @Override
    public String imprimirDocumento() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "DNI: " + dni + "\n" +
                "Email: " + email + "\n" +
                "Habilidades: " + String.join(", ", habilidades) + "\n";
    }


}
