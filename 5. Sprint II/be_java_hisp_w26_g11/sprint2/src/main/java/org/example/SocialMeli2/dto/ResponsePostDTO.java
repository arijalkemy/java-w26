package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * DTO para la respuesta de un Post.
 * Este DTO se utiliza para representar la información de un post en la respuesta a una solicitud.
 */
@AllArgsConstructor
@Data
public class ResponsePostDTO {
    /**
     * El ID del usuario que creó el post.
     */
    @JsonProperty("user_id")
    private int userId;

    /**
     * La lista de posts.
     * Cada post en la lista es representado como un PostDTO.
     */
    @JsonSerialize(contentAs = PostDTO.class)
    @JsonDeserialize(contentAs = PostDTO.class)
    private List<PostDTO> posts;
}
