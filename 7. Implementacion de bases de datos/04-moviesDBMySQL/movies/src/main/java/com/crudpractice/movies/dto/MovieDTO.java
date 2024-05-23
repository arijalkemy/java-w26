package com.crudpractice.movies.dto;

import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class MovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;
    @JsonIgnore
    private Genre genre;
    @JsonIgnore
    private List<Actor> actorsInMovie;
}
