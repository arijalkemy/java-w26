package bootcamp.bendezujonathan.romanNumbers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvertionDto {

    @JsonProperty("original-number")
    private String originalNumber;
    private String convertion;

}
