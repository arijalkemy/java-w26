package org.ggomezr.miniseries.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MiniSerieDTO {
    private Long id;
    private String name;
    private Double rating;
    private Integer amount_of_awards;
}
