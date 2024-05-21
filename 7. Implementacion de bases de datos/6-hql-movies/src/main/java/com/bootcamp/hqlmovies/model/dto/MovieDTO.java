package com.bootcamp.hqlmovies.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class MovieDTO implements Serializable  {
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Double rating;
    private Integer awards;
    private Timestamp releaseDate;
    private Integer length;
}
