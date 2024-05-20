package co.com.mercadolibre.qatesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {

    private Long idCase;
    private String description;
    private Boolean tested;
    private String passed;
    private Integer numberOfTries;
    private LocalDate lastUpdate;

}
