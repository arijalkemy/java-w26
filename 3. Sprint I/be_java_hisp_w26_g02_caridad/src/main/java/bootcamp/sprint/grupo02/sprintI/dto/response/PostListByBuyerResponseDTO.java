package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostListByBuyerResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    private List<PostResponseDTO> posts;
}
