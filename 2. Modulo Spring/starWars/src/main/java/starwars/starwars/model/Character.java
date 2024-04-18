package starwars.starwars.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Character {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
}
