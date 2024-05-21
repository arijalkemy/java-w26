package bootcamp.bendezujonathan.hql.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ActorResponse {

    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    @JsonProperty(value = "favorite_movie")
    private MovieResponse favMovie;

}
