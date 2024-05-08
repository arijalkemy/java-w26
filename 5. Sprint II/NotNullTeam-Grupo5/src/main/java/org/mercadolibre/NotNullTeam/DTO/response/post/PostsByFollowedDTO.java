package org.mercadolibre.NotNullTeam.DTO.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsByFollowedDTO {
    @JsonProperty("user_id")
    private Long userId;
    private List<PostResponseDTO> posts;
}
