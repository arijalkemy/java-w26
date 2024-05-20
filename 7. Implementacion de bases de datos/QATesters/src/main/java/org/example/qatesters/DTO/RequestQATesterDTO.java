package org.example.qatesters.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestQATesterDTO {
    private String description;
    private boolean tested;
    private boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;
}
