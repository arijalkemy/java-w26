package meli.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricsLinkDTO {
    private Integer id;
    private Integer redirectionCount;
}
