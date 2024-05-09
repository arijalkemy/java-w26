package org.mercadolibre.NotNullTeam.DTO.response.post;

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
    private Long user_id;
    private List<PostResponseDTO> posts;
}
