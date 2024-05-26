package Ejercicio.TestCase.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseResponseDto {
    private String description;

    private boolean tested;

    private boolean passed;

    private Integer numberOfTries;

    private LocalDate lastUpdate;
}
