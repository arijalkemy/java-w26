package com.demospring.personajesdestarwars.repository;

import com.demospring.personajesdestarwars.model.Personaje;
import org.springframework.stereotype.Repository;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajesJSON {
    private List<Personaje> personajes;

    public PersonajesJSON() {
        leerPersonajes();
    }

    public List<Personaje> getPersonajes(){
        return this.personajes;
    }

    private void leerPersonajes() {
        try (JsonReader reader = Json.createReader(new FileReader("src/main/java/com/demospring/personajesdestarwars/repository/3. c. starwars.json"))) {
            JsonArray jsonArray = reader.readArray();
            this.personajes = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.getJsonObject(i);
                Personaje personaje = new Personaje(
                        jsonObject.getString("name"),
                        jsonObject.getInt("height"),
                        jsonObject.getInt("mass"),
                        jsonObject.getString("hair_color"),
                        jsonObject.getString("skin_color"),
                        jsonObject.getString("eye_color"),
                        jsonObject.getString("birth_year"),
                        jsonObject.getString("gender"),
                        jsonObject.getString("homeworld"),
                        jsonObject.getString("species")
                );
                this.personajes.add(personaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
