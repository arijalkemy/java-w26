package App.repository;

import App.tdo.CharacterTDO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryWars {
    public List<CharacterTDO> characterList;

    public RepositoryWars() {
        characterList = new ArrayList<>();
    }

    public void populate() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y convertirlo en un arreglo de objetos JSON
            JsonNode jsonNode = objectMapper.readTree(new File("starwars.json"));

            // Iterar sobre cada objeto JSON en el arreglo
            for (JsonNode objeto : jsonNode) {
                // Extraer datos de cada objeto
                String nombre = objeto.get("name").asText();
                String altura = objeto.get("height").asText();
                String masa = objeto.get("mass").asText();
                String colorCabello = objeto.get("hair_color").asText();
                String colorPiel = objeto.get("skin_color").asText();
                String colorOjos = objeto.get("eye_color").asText();
                String añoNacimiento = objeto.get("birth_year").asText();
                String género = objeto.get("gender").asText();
                String planetaNatal = objeto.get("homeworld").asText();
                String especie = objeto.get("species").asText();

                // Crear un objeto CharacterTDO con los datos extraídos
                CharacterTDO character = new CharacterTDO(nombre, altura, masa, colorCabello, colorPiel, colorOjos,
                        añoNacimiento, género, planetaNatal, especie);
                characterList.add(character);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}