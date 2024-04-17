package com.example.personajesStarWars.repository;

import com.example.personajesStarWars.dto.JsonDTO;
import com.example.personajesStarWars.model.Persona;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements  IPersonaRepository{


    private List<Persona> personajes = new ArrayList<>();

    public PersonaRepositoryImpl (){
        this.leerJson();
    }



    private void leerJson(){
        String path = "src/main/resources/starwars.json";
        Gson json = new Gson();
        try{
            FileReader reader = new FileReader(path);
            JsonDTO datos = json.fromJson(reader, JsonDTO.class);
            this.personajes = datos.getResultados();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }




    @Override
    public List<Persona> obtenerPersonas() {
        return personajes;
    }
}
