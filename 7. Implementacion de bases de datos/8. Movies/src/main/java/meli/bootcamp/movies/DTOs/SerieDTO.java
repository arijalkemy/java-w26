package meli.bootcamp.movies.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    @JsonProperty("genre_id")
    private Long genreId;
}
