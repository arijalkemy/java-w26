package com.example.ejerciciodeportistas.data;

import com.example.ejerciciodeportistas.clases.Deporte;
import com.example.ejerciciodeportistas.clases.Deportista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB {
    List<Deportista> deportistas;
    List<Deporte> deportes;

    public DB(){
        deportistas = new ArrayList<>();
        deportes = new ArrayList<>();
    }

    public List<Deporte> obtenerDeportes(){
        return deportes;
    }

    public Deporte obtenerDeporte( String nombre ){
        return deportes.stream().filter( x -> x.getNombre().equals(nombre)).findFirst().get();
    }

    public List<Deportista> obtenerDeportistas(){
        return deportistas;
    }

    public void cargarDeportes( Deporte ... deporte ){
        this.deportes.addAll( Arrays.stream(deporte).toList() );
    }
    public void cargarDeportistas( List<Deportista> deportistas ){
        this.deportistas.addAll(deportistas);
    }

}
