package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    private String favoriteMovie;
}
