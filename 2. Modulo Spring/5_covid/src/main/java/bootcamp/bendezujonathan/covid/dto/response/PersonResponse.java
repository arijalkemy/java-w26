package bootcamp.bendezujonathan.covid.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private String name;
    private String surname;
    private List<String> symptoms;
}
