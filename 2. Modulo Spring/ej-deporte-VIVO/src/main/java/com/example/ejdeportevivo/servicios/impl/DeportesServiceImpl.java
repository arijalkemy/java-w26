package com.example.ejdeportevivo.servicios.impl;

import com.example.ejdeportevivo.modelo.Deporte;
import com.example.ejdeportevivo.modelo.Persona;
import com.example.ejdeportevivo.repositorios.Repositorio;
import com.example.ejdeportevivo.servicios.IDeportesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportesServiceImpl implements IDeportesService {
    Repositorio<Deporte> deporteRepositorio;

    public DeportesServiceImpl() {

        this.deporteRepositorio = new Repositorio<>();

        Deporte rugby = new Deporte("Rugby", 4);
        Deporte boxeo = new Deporte("Boxeo", 4);
        Deporte futbol = new Deporte("Futbol", 4);
        Deporte basquet = new Deporte("Basquet", 4);
        Deporte tenis = new Deporte("Tenis", 4);

        this.deporteRepositorio.guardar(rugby);
        this.deporteRepositorio.guardar(futbol);
        this.deporteRepositorio.guardar(boxeo);
        this.deporteRepositorio.guardar(basquet);
        this.deporteRepositorio.guardar(tenis);

    }

    public List<Deporte> obtenerTodosLosDeportes(){
        return this.
                deporteRepositorio.
                obtenerTodos();
    }

    public Optional<Deporte> obtenerDeportePorNombre(String nombre) {
        List<Deporte> deportes = deporteRepositorio.obtenerTodos();

        return deportes
                .stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }


}
