package org.example.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO para los seguidores de un vendedor.
 * Este DTO se utiliza para representar la lista de seguidores que un vendedor específico tiene.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name", "followers"})
public class SellerFollowerDto implements Serializable {
    /**
     * El ID del vendedor.
     */
    @JsonProperty("user_id")
    private int UserId;

    /**
     * El nombre del vendedor.
     */
    @JsonProperty("user_name")
    private String sellerName;

    /**
     * La lista de seguidores del vendedor.
     * Cada seguidor en la lista es representado como un BasicCustomerDto.
     */
    private List<BasicCustomerDto> followers;
}
