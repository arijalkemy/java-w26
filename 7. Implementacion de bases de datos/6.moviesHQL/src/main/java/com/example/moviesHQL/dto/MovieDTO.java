package com.example.moviesHQL.dto;

import com.example.moviesHQL.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Double rating;
    private Integer awards;
    private Timestamp releaseDate;
    private Integer length;
    private List<Actor> actors;
}
