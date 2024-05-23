package org.example.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class EpisodeDTO {
    private String title;
    private Integer number;
    private Double rating;
    @JsonProperty("release_date")
    private Date releaseDate;

}
