package com.api.socialmeli.utils;

import com.api.socialmeli.exception.BadRequestException;

public class FollowersOfSellerValidation {
    /**
     * @description returns a boolean if the seller_id is correct, throws and exception if seller_id doesnt have the correct format
     * @param seller_id
     * @return boolean
     */
    public static boolean isValidSellerId(int seller_id){
        /* se realiza validacion dentro del id del venedor enviado */
        if(seller_id <= 0){
            throw new BadRequestException("El id del vendedor no puede ser menor o igual a cero");
        }
        return true;
    }

    /**
     * @description returns a boolean if the order is name_asc or name_desc, throws an exception if order doesnt have the correct format
     * @param order
     * @return boolean
     */
    public static boolean isValidOrder(String order){
        /* se realiza validacion dentro del order enviado */
        if(!order.equals("name_desc") && !order.equals("name_asc") && !order.equals("")){
            throw new BadRequestException("El tipo de ordenamiento no es el permitido");
        }
        return true;
    }
}
