package com.example.ejdeportevivo.servicios.impl;

import com.example.ejdeportevivo.modelo.Deporte;
import com.example.ejdeportevivo.modelo.Persona;
import com.example.ejdeportevivo.repositorios.Repositorio;
import com.example.ejdeportevivo.servicios.IPersonasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonasServiceImpl implements IPersonasService {
    private DeportesServiceImpl deportesService;
    Repositorio<Persona> personaRepositorio;

    public PersonasServiceImpl(DeportesServiceImpl deportesService){

        this.personaRepositorio = new Repositorio<>();

        this.deportesService = deportesService;

        Optional<Deporte> boxeoOptional = deportesService.obtenerDeportePorNombre("Boxeo");
        Optional<Deporte> futbolOptional = deportesService.obtenerDeportePorNombre("Futbol");


        if(futbolOptional.isPresent() && boxeoOptional.isPresent()){
            this.personaRepositorio.guardar(
                    new Persona("Nacho", "Ruiz Diaz", 22, boxeoOptional.get())
            );
            this.personaRepositorio.guardar(
                    new Persona("Fernando", "Ruiz Diaz", 42, futbolOptional.get())
            );
        }
    }

    public List<Persona> obtenerTodasLasPersonas(){
        return this.personaRepositorio.obtenerTodos();
    }
}
