package com.w26.starwars.util;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.starwars.entity.Character;
import lombok.extern.java.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Log
public class StarWarsLoader {

    public static List<Character> loadStarWarsInfo(){
        Resource resourceStarWarsCharacters = new ClassPathResource("starwars.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Character> listCharacters = null;

        try {
           Character[] mapFileCharacter = mapper.readValue(resourceStarWarsCharacters.getFile(), CharacterFile[].class);
            listCharacters = Arrays.stream(mapFileCharacter).toList();
        } catch (DatabindException e)
        {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  listCharacters;
    }
}
