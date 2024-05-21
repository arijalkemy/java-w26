package bootcamp.bendezujonathan.hql.dto.response;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EpisodeResponse {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private LocalDate releaseDate;
    private Integer number;
    private Double rating;
    private List<ActorResponse> actors;
    private SerieResponse serie;

}
