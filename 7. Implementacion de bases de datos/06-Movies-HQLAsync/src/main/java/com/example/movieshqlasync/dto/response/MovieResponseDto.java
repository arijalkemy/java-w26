package com.example.movieshqlasync.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String title;
    private Double rating;
    private int awards;
    private int length;
}
