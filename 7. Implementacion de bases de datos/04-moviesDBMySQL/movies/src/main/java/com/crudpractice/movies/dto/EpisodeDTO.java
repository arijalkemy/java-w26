package com.crudpractice.movies.dto;


import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Season;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private Integer id;
    private String title;
    private int numberOfEpisode;
    private Date releaseDate;
    private double rating;
    @JsonIgnore
    private Season season;
    @JsonIgnore
    private List<Actor> actorsInEpisode;
}
