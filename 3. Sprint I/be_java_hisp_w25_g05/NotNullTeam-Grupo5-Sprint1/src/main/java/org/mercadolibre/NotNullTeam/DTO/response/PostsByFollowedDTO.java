package org.mercadolibre.NotNullTeam.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsByFollowedDTO {
    private Long user_id;
    private List<PostResponseDTO> posts;
}
