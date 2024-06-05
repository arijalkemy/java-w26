package com.deportista.demo.repositorio;

import com.deportista.demo.modelo.Deporte;
import com.deportista.demo.modelo.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeportista {
    //Atributos
    private List<Deporte> listaDeporte = new ArrayList<>();
    private List<Persona> listaPersonas = new ArrayList<>();

    public RepositorioDeportista(){
        this.ejemplificarRepositorioDeportes();
        this.ejemplificarRepositorioPersona();
    }

    public void ejemplificarRepositorioDeportes(){
        listaDeporte.add(new Deporte("Futbol", "Nivel intermedio"));
        listaDeporte.add(new Deporte("Baloncesto", "Nivel avanzado"));
        listaDeporte.add(new Deporte("Tenis", "Nivel principiante"));
        listaDeporte.add(new Deporte("Voleibol", "Nivel intermedio"));
        listaDeporte.add(new Deporte("Atletismo", "Nivel avanzado"));
        listaDeporte.add(new Deporte("Natación", "Nivel principiante"));
        listaDeporte.add(new Deporte("Golf", "Nivel intermedio"));
        listaDeporte.add(new Deporte("Rugby", "Nivel avanzado"));
        listaDeporte.add(new Deporte("Ciclismo", "Nivel principiante"));
        listaDeporte.add(new Deporte("Escalada", "Nivel avanzado"));
    }

    public void ejemplificarRepositorioPersona(){

        listaPersonas.add(new Persona("Cristian", "Andres", "25"));
        listaPersonas.add(new Persona("María", "González", "30"));
        listaPersonas.add(new Persona("Juan", "Martínez", "28"));
        listaPersonas.add(new Persona("Laura", "Pérez", "22"));
        listaPersonas.add(new Persona("Pedro", "Sánchez", "35"));
        listaPersonas.add(new Persona("Pedro", "Gomez", "34"));
        listaPersonas.add(new Persona("Sara", "Pérez", "28"));
        listaPersonas.add(new Persona("Daniel", "Sanchez", "30"));
        listaPersonas.add(new Persona("Elena", "Hernandez", "33"));
        listaPersonas.add(new Persona("Carlos", "Diaz", "25"));
    }

    public Deporte filtrarDeporte(String nombreDeporte){
        for (Deporte deporte : listaDeporte) {
            if(deporte.getNombre().equals(nombreDeporte)){
                return deporte;
            }
        }
        return new Deporte();
    }

    public List<Deporte> getListaDeporte() {
        return listaDeporte;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
