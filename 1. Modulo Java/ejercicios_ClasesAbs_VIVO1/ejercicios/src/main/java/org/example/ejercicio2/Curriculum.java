package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
    public String  nombre;
    public String apellido;
    public List<String> habilidades;

        public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        String escribir= "Nombre: "+this.nombre+", Apellido: "+ this.apellido+", Lista de habilidades: ";
            for(String habilidad: habilidades){
                escribir+=habilidad+", ";
            }
        return escribir;
    }
}
