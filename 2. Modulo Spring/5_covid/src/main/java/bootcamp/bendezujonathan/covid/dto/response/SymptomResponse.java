package bootcamp.bendezujonathan.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomResponse {

    private int code;
    private String name;
    private String severity;

}
