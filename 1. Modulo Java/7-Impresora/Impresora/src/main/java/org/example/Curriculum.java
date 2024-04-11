package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IImprimir{
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = new ArrayList<String>(habilidades);
    }
    @Override
    public String toString() {
        return "Nombre: "+nombre+" Apellido: "+apellido+" Habilidades: "+habilidades.toString();
    }
}
