package com.example.HQL.dto.response;

import com.example.HQL.model.Season;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeResponseDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("title")
    private String title;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("rating")
    private Double rating;
}
