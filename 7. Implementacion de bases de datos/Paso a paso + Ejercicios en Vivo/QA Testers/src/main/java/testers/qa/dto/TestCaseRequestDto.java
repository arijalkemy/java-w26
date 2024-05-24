package testers.qa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseRequestDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate lastUpdate;
}
