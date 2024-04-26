package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostListResponseDTO {
    private int user_id;
    private String user_name;
    private List<PromoDTO> posts;
}
