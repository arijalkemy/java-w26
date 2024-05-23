package com.moviesmysql.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviesmysql.models.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {
    private Long id;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Integer number;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    private Double rating;
    @JsonProperty("season_id")
    private Long seasonId;
}
