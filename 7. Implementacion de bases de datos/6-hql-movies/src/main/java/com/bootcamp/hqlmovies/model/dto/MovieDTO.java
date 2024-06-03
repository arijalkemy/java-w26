package com.bootcamp.hqlmovies.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO implements Serializable  {
    private Integer id;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Double rating;
    private Integer awards;
    private Timestamp releaseDate;
    private Integer length;
}
