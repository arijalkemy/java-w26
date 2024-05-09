package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SellerFollowersResponseDTO {
    @JsonUnwrapped
    private UserResponseDTO user;
    @JsonProperty("followers_count")
    private int followersCount;
}
