package com.api.socialmeli.dto;

import com.api.socialmeli.entity.Seller;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

//Clase Dto que personaliza la salida para el endpoint 6 y 8
//Solicita la lista de los vendedores que sigue un cliente
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerFollowedListDTO {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private Integer user_id;

    @NotBlank(message = "El usuario no puede estar vacio")
    @Size(max = 15, message = "El nombre no puede ser mayor a 15 caracteres")
    private String user_name;

    private List<@Valid Seller> followed;
}
