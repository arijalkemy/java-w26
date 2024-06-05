package org.example.testjpahql.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EpisodeDTO {
    private String title;
    private Integer number;
    private Date releaseDate;
}
