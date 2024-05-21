package bootcamp.bendezujonathan.hql.dto.response;

import java.time.LocalDateTime;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponse {
    
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;


}
