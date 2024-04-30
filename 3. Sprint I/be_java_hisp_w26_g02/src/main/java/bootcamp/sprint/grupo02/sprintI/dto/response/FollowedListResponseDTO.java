package bootcamp.sprint.grupo02.sprintI.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedListResponseDTO {

    @JsonUnwrapped
    private UserResponseDTO user;
    private List<UserResponseDTO> followed;
    
}
