package bootcamp.bendezujonathan.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

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
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
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

    @JsonSetter("height")
    public void setHeight(String value) {
        this.height = (value.equals("NA")) ? 0 : (int) Double.parseDouble(value);
    }

    @JsonSetter("mass")
    public void setMass(String value) {
        value = value.replace(",", ".");
        this.mass = (value.equals("NA")) ? 0 : (int) Double.parseDouble(value);
    }
}
