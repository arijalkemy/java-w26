package com.api.socialmeli.utils;

import com.api.socialmeli.dto.UserDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoShort {

    /**
     * @descripcion: Se realiza ordenamiento de lista de usuarios por nombre ascende o desendente
     * @param list
     * @param order name_asc, name_desc o vacio
     * @return se retorna una lista de UserDTO de manera ordenada por nombre
     */
    public static List<UserDto> sortList(List<UserDto> list, String order){
        if(order.equals("name_asc")){
            return list.stream()
                    .sorted(Comparator.comparing(UserDto::getUser_name))
                    .collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            return list.stream()
                    .sorted(Comparator.comparing(UserDto::getUser_name).reversed())
                    .collect(Collectors.toList());
        }else{
            return list;
        }
    }
}
