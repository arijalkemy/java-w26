package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;
import lombok.Data;

@Data
public class CreateCharacterUtil {


    public static CharacterDTO createLuke(){
        CharacterDTO luke = new CharacterDTO("Luke Skywalker", "blond",
                "fair", "blue", "19BBY", "male",
                "Tatooine", "Human", 172, 77);

        return luke;
    }
}
