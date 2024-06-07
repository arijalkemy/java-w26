package com.mercadolibree.HQL_movies_db.dto;

import lombok.Data;

@Data
public class ActorsResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private Double rating;
}
