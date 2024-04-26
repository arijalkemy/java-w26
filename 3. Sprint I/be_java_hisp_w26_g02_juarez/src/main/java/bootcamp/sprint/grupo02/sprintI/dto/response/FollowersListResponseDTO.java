package bootcamp.sprint.grupo02.sprintI.dto.response;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FollowersListResponseDTO {
    @JsonUnwrapped
    private UserResponseDTO user;
    private List<UserResponseDTO> followers;
}
