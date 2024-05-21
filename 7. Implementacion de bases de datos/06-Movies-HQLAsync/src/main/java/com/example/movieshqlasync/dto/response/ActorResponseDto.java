package com.example.movieshqlasync.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponseDto {
    Integer id;
    String firstName;
    String lastName;
    Double rating;
    Integer favoriteMovie;
}
