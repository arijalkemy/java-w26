package com.example.ejerciciodeportistas.service.service.impl;

import com.example.ejerciciodeportistas.clases.Deporte;
import com.example.ejerciciodeportistas.clases.Deportista;
import com.example.ejerciciodeportistas.data.DB;
import com.example.ejerciciodeportistas.service.IDeportistasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportistasServiceImpl implements IDeportistasService {

    private DB db;

    public DeportistasServiceImpl(){
        this.db = crearBase();
    }

    @Override
    public List<Deporte> obtenerDeportes() {
        return db.obtenerDeportes();
    }

    @Override
    public Deporte obtenerDeporte(String nombre ) {
        return db.obtenerDeporte( nombre );
    }

    @Override
    public List<Deportista> obtenerDeportistas() {
        return db.obtenerDeportistas();
    }

    private DB crearBase(){
        DB db = new DB();

        Deporte futbol = new Deporte("Futbol", 7);
        Deporte basquet = new Deporte("Basquet", 6);

        db.cargarDeportes( futbol , basquet );

        //Lista de deportistas
        List<Deportista> deportistas = List.of( new Deportista("Leonel", "Messi", 36, futbol), new Deportista("Lebron", "James", 37, basquet) );
        db.cargarDeportistas( deportistas );

        return db;
    }
}
