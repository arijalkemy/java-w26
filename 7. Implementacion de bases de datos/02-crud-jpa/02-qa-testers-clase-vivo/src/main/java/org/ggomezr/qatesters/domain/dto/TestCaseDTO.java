package org.ggomezr.qatesters.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCaseDTO {
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
