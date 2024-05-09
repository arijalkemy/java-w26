package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para contar los seguidores de un usuario.
 * Este DTO se utiliza para representar la cantidad de seguidores que tiene un usuario.
 */
@Data
@AllArgsConstructor
public class CountFollowersDTO {
    /**
     * El ID del usuario.
     */
    @JsonProperty("user_id")
    private int userId;

    /**
     * El nombre de usuario.
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * La cantidad de seguidores que tiene el usuario.
     */
    @JsonProperty("followers_count")
    private int followersCount;
}
