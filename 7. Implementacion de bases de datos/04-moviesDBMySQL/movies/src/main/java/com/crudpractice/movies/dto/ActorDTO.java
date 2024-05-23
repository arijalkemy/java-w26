package com.crudpractice.movies.dto;

import com.crudpractice.movies.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
}
