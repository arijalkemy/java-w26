package org.ejercicio.starwars.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicio.starwars.entity.Character;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockDB {
    public static List<Character> characters = new ArrayList<>();

    public static List<Character> simulaBD(){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/resources/static/starwars.json")){
            Object obj = parser.parse(reader);
            JSONArray personasList = (JSONArray) obj;
            ObjectMapper mapper = new ObjectMapper();
            List<Character> p1 = Arrays.asList(mapper.convertValue(personasList, Character[].class));
            return p1;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }catch (ParseException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
