package com.bootcamp.hqlmovies.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorDTO implements Serializable {
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private MovieDTO favoriteMovie;
}
