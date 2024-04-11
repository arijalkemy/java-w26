package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private String domicilio;
    private List<String> habilidades;

    public Persona(String nombre, int edad, String dni, String domicilio) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.domicilio = domicilio;
        this.habilidades = new ArrayList();
    }

    public void agregarHabilidad( String habilidad ){
        this.habilidades.add(habilidad);
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
