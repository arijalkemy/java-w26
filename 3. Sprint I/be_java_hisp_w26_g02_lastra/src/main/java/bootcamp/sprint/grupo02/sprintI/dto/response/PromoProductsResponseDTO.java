package bootcamp.sprint.grupo02.sprintI.dto.response;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromoProductsResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<PostDTO> posts;
}
