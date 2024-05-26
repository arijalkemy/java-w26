package com.example.HQL.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesResponseDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("title")
    private String title;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    private GenreResponseDto genre;
}
