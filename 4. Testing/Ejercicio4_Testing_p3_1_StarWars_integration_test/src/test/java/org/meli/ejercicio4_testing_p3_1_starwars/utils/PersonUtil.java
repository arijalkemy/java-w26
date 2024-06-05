package org.meli.ejercicio4_testing_p3_1_starwars.utils;

import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

    public static List<CharacterDTO> getListPerson(){
            List<CharacterDTO> characterDTOS = new ArrayList<>();
            // Crear el primer objeto
            CharacterDTO lukeSkywalker = new CharacterDTO();
            lukeSkywalker.setName("Luke Skywalker");
            lukeSkywalker.setHeight(172);
            lukeSkywalker.setMass(77);
            lukeSkywalker.setHair_color("blond");
            lukeSkywalker.setSkin_color("fair");
            lukeSkywalker.setEye_color("blue");
            lukeSkywalker.setBirth_year("19BBY");
            lukeSkywalker.setGender("male");
            lukeSkywalker.setHomeworld("Tatooine");
            lukeSkywalker.setSpecies("Human");

            // Crear el segundo objeto
            CharacterDTO c3po = new CharacterDTO();
            c3po.setName("C-3PO");
            c3po.setHeight(167);
            c3po.setMass(75);
            c3po.setHair_color("NA");
            c3po.setSkin_color("gold");
            c3po.setEye_color("yellow");
            c3po.setBirth_year("112BBY");
            c3po.setGender("NA");
            c3po.setHomeworld("Tatooine");
            c3po.setSpecies("Droid");

            // Crear el tercer objeto
            CharacterDTO r2d2 = new CharacterDTO();
            r2d2.setName("R2-D2");
            r2d2.setHeight(96);
            r2d2.setMass(32);
            r2d2.setHair_color("NA");
            r2d2.setSkin_color("white, blue");
            r2d2.setEye_color("red");
            r2d2.setBirth_year("33BBY");
            r2d2.setGender("NA");
            r2d2.setHomeworld("Naboo");
            r2d2.setSpecies("Droid");
            characterDTOS.add(lukeSkywalker);
            characterDTOS.add(c3po);
            characterDTOS.add(r2d2);
        return characterDTOS;
    }
}
