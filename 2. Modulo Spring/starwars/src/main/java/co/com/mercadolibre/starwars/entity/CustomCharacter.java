package co.com.mercadolibre.starwars.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomCharacter {

    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
