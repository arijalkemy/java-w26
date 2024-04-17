package bootcamp.bendezujonathan.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}