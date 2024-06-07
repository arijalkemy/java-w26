package com.mercadolibree.HQL_movies_db.dto;

import lombok.Data;

@Data
public class MoviesResponseDto {
    private String title;
    private Double rating;
    private int awards;
    private int genreId;
}
