package org.mercadolibre.multicapatemplate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    String name;
    Double height;
    Double mass;
    String gender;
    String species;

    @JsonProperty("hair_color")
    String hairColor;

    @JsonProperty("skin_color")
    String skinColor;

    @JsonProperty("eye_color")
    String eyeColor;

    @JsonProperty("birth_year")
    String birthYear;

    @JsonProperty("homeworld")
    String homeWorld;

    public Double parseDouble(String number) {
        if ("NA".equalsIgnoreCase(number)) {
            return null;
        }

        if(number.contains(",")) {
            return Double.parseDouble(number.replace(",", "."));
        }

        return Double.parseDouble(number);
    }

    @JsonSetter("height")
    public void setHeight(String height) {
        this.height = parseDouble(height);
    }

    @JsonSetter("mass")
    public void setMass(String mass) {
        this.mass = parseDouble(mass);
    }
}
