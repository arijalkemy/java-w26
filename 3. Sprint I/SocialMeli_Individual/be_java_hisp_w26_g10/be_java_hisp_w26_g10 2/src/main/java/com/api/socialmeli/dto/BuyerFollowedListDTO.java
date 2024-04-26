package com.api.socialmeli.dto;

import com.api.socialmeli.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Clase Dto que personaliza la salida para el endpoint 6 y 8
//Solicita la lista de los vendedores que sigue un cliente
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerFollowedListDTO {
    private Integer user_id;
    private String user_name;
    private List<Seller> followed;
}
