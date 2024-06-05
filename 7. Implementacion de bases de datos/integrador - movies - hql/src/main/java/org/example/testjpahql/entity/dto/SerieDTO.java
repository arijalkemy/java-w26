package org.example.testjpahql.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SerieDTO {
    private String title;
    private Date releaseDate;
    private Date endDate;
}
