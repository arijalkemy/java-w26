package bootcamp.bendezujonathan.starwars.repository.interfaces;

import java.util.List;
import bootcamp.bendezujonathan.starwars.model.Character;

public interface ICharacterRepository {
    List<Character> CHARACTERS = List.of(
            new Character("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human"),
            new Character("Darth Vader", 202, 136, "None", "White", "Yellow", "41.9BBY", "Male", "Tatooine", "Human"),
            new Character("Leia Organa", 150, 49, "Brown", "Light", "Brown", "19BBY", "Female", "Alderaan", "Human"),
            new Character("Han Solo", 180, 80, "Brown", "Fair", "Brown", "29BBY", "Male", "Corellia", "Human"),
            new Character("Chewbacca", 228, 112, "Brown", "Fur", "Blue", "200BBY", "Male", "Kashyyyk", "Wookiee"),
            new Character("Yoda", 66, 17, "White", "Green", "Brown", "896BBY", "Male", "Unknown", "Yoda's species"),
            new Character("Obi-Wan Kenobi", 180, 77, "White", "Fair", "Blue", "57BBY", "Male", "Stewjon", "Human"),
            new Character("Padmé Amidala", 165, 45, "Brown", "Light", "Brown", "46BBY", "Female", "Naboo", "Human"));

    static List<Character> findAll() {
        return CHARACTERS;
    }
}
