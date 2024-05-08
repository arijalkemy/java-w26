package bootcamp.sprint.grupo02.sprintI.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FollowedListResponseDTO {

    @JsonUnwrapped
    private UserResponseDTO user;
    private List<UserResponseDTO> followed;
    
}
