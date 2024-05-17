package org.ggomezr.miniseries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieDTO {
    private String name;
    private Double rating;
    private Integer amount_of_awards;
}
