package bootcamp.bendezujonathan.starwars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public boolean nameContains(String name) {
        name = name.toLowerCase();
        return this.name
                .toLowerCase()
                .contains(name);
    }

}
