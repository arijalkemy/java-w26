package bootcamp.bendezujonathan.hql.dto.response;

import java.time.LocalDateTime;
import java.util.List;

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
public class ActorMovieResponse {
    
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonProperty("name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Integer ranking;
    private Boolean active;
    private List<MovieResponse> movies;

}
