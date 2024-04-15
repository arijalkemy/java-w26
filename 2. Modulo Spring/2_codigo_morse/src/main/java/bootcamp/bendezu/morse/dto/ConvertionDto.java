package bootcamp.bendezu.morse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvertionDto {

    @JsonProperty("original-message")
    private String originalMessage;
    private String convertion;

}
