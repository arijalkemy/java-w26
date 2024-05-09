package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * DTO básico para la entidad Customer.
 * Este DTO se utiliza para representar la información básica de un cliente.
 */
@Data
public class BasicCustomerDto implements Serializable {
    /**
     * El ID del cliente.
     */
    @JsonProperty("user_id")
    private int customerId;

    /**
     * El nombre de usuario del cliente.
     */
    @JsonProperty("user_name")
    private String userName;

    /**
     * La lista de IDs de los vendedores a los que el cliente está siguiendo.
     * Esta propiedad se ignora al serializar el objeto a JSON.
     */
    @JsonIgnore
    private List<Integer> following;
}
