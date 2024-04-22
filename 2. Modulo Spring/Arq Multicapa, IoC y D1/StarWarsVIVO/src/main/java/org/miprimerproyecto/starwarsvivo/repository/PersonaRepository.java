package org.miprimerproyecto.starwarsvivo.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.miprimerproyecto.starwarsvivo.dto.PersonaDTO;
import org.miprimerproyecto.starwarsvivo.model.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository {
    private List<Persona> personas= new ArrayList<>();

    public PersonaRepository() throws IOException {
        try {
            loadDataBase();
        }
        catch (FileNotFoundException err){
            throw new IOException(err);
        }


    }

    private void loadDataBase() throws IOException{
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file= ResourceUtils.getFile("src/main/java/org/miprimerproyecto/starwarsvivo/starwars.json");
        this.personas= objectMapper.readValue(file, new TypeReference<List<Persona>>(){});
    }

    @Override
    public List<Persona> getPersonas() {
        return this.personas;
    }
}
