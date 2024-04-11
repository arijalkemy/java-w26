package org.example.archivos;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IArchivo{

    private String nombre;
    private List<String> listaDeHabilidades;

    public Curriculum(String nombre, List<String> listaDeHabilidades){
        this.nombre = nombre;
        this.listaDeHabilidades = listaDeHabilidades;
    }

    @Override
    public String getContenido() {
        return "Nombre: " + this.nombre + ". Habilidades: ... ";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListaDeHabilidades() {
        return listaDeHabilidades;
    }

    public void setListaDeHabilidades(ArrayList<String> listaDeHabilidades) {
        this.listaDeHabilidades = listaDeHabilidades;
    }
}
