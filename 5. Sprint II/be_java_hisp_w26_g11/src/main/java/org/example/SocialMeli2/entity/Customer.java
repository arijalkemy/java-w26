package org.example.SocialMeli2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidad para el cliente.
 * Esta entidad se utiliza para representar la información de un cliente en el sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    /**
     * El ID del cliente.
     */
    @JsonProperty("user_id")
    private int userId;

    /**
     * El nombre de usuario del cliente.
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * La lista de IDs de los vendedores a los que el cliente está siguiendo.
     */
    @JsonProperty("following")
    private List<Integer> sellers;

    /**
     * Método para agregar un vendedor a la lista de vendedores a los que el cliente está siguiendo.
     * @param sellerId El ID del vendedor a agregar.
     */
    public void addSeller(int sellerId) {
        sellers.add(sellerId);
    }
}
