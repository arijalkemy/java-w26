package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoListBySeller {
    @JsonUnwrapped
    private UserResponseDTO userResponseDTO;
    private List<PostPromoResponseDTO> posts;
}
