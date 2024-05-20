package bootcamp.bendezujonathan.testcases.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TestCaseResponse {
 
    @JsonProperty("testcase_id")
    private int id;
    private String description;
    private Boolean tested;
    private Boolean passed;    
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;

}
