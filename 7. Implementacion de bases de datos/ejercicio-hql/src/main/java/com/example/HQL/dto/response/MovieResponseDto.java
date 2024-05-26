package com.example.HQL.dto.response;

import com.example.HQL.model.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("title")
    private String title;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("awards")
    private Integer awards;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("length")
    private Integer length;
    private GenreResponseDto genre;
}
