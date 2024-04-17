package com.ejercicio.starwars.repositories;

import com.ejercicio.starwars.models.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private List<Character> characterList;

    public CharacterRepository(List<Character> characterList) {
        this.characterList = createCharacters();
    }

    public List<Character> findByName(String nameSubstring) {
        return characterList
                .stream()
                .filter(character -> character.getName().contains(nameSubstring))
                .toList();
    }

    private List<Character> createCharacters() {
        List<Character> characterList = new ArrayList<Character>();

        characterList.add(new Character(
                "Luke Skywalker",
                80,
                70,
                "Rubio",
                "Blanco",
                "Celeste",
                1985,
                "Masculino",
                "Tierra",
                new ArrayList<String>(){{
                    add("Salchicha");
                    add("Pug");
                }}
        ));
        characterList.add(new Character(
                "Darth Vader",
                90,
                80,
                "Castaño",
                "Blanco",
                "Marron",
                1970,
                "Masculino",
                "Marte",
                new ArrayList<String>(){{
                    add("Salchicha");
                    add("Pug");
                }}
        ));
        characterList.add(new Character(
                "Darth Maul",
                90,
                80,
                "Negro",
                "Negro",
                "Marron",
                19875,
                "Masculino",
                "Jupiter",
                new ArrayList<String>(){{
                    add("Salchicha");
                    add("Pug");
                }}
        ));

        return characterList;
    }
}
