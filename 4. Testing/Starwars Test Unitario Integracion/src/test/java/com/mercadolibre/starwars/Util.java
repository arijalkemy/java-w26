package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class Util {

    public static CharacterDTO characterTest(){
        return new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77);
    }

}
