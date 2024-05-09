package bootcamp.sprint.grupo02.sprintI.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FollowedListResponseDTO {

    @JsonUnwrapped
    private UserResponseDTO user;
    private List<UserResponseDTO> followed;
    
}
