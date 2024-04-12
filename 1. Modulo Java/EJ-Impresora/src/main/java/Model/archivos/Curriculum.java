package Model.archivos;

import Interface.IArchivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curriculum implements IArchivo {
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("CV:");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("DNI: " + this.dni);
        System.out.println("Habilidades");
        for(String habilidad: habilidades){
            System.out.println("Habilidad: " + habilidad);
        }
    }
}
