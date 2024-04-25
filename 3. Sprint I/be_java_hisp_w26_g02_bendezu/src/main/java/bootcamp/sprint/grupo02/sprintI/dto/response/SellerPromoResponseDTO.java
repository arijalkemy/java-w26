package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class SellerPromoResponseDTO {
 
    @JsonUnwrapped
    private UserResponseDTO user;
    @JsonProperty("followers_count")
    private long followersCount;
    private List<PostResponseDTO> posts;



}
