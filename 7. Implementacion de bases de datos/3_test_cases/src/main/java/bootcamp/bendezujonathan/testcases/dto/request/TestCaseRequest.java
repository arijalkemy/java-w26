package bootcamp.bendezujonathan.testcases.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestCaseRequest {
    
    private String description;
    private Boolean tested;
    private Boolean passed;    
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

}
