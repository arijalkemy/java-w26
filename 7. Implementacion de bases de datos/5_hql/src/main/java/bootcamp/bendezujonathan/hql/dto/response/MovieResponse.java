package bootcamp.bendezujonathan.hql.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MovieResponse {
    
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releasDate;
    private Integer length;
    private GenreResponse genre;
}
