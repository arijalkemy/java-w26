package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.SocialMeli2.entity.Post;

import java.io.Serializable;
import java.util.List;

/**
 * DTO básico para la entidad Seller.
 * Este DTO se utiliza para representar la información básica de un vendedor.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicSellerDTO implements Serializable {
    /**
     * El ID del vendedor.
     */
    @JsonProperty("user_id")
    @JsonAlias("seller_id")
    private int sellerId;

    /**
     * El nombre de usuario del vendedor.
     */
    @JsonProperty("user_name")
    @JsonAlias("seller_name")
    private String sellerName;

    /**
     * La lista de posts del vendedor.
     * Esta propiedad se ignora al serializar el objeto a JSON.
     */
    @JsonIgnore
    private List<Post> posts;

    /**
     * La lista de IDs de los clientes que siguen al vendedor.
     * Esta propiedad se ignora al serializar el objeto a JSON.
     */
    @JsonIgnore
    private List<Integer> followers;
}
