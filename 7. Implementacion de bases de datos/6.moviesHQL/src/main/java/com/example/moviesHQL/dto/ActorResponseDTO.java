package com.example.moviesHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
}
