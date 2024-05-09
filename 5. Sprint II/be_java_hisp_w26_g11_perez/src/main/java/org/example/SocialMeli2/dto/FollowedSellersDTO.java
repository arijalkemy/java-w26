package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO para los vendedores seguidos por un usuario.
 * Este DTO se utiliza para representar la lista de vendedores que un usuario específico está siguiendo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "UserId", "customerName", "followed" })
public class FollowedSellersDTO implements Serializable {
    /**
     * El ID del usuario.
     */
    @JsonProperty("user_id")
    private int UserId;

    /**
     * El nombre de usuario.
     */
    @JsonProperty("user_name")
    private String customerName;

    /**
     * La lista de vendedores que el usuario está siguiendo.
     */
    private List<BasicSellerDTO> followed;
}
