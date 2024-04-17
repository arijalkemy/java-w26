package bootcamp.spring.ej_star_wars.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
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

    public boolean nameContains(String string) {
        String nameToUpper = name.toUpperCase();
        return nameToUpper
                .contains(string.toUpperCase());
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
