package meli.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkMetricsDTO {
    private Integer id;
    private Integer redirectionCount;
}
