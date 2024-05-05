package com.api.socialmeli.validators;

import com.api.socialmeli.dto.PostPromoDto;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.utils.Dates;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class PostDtoValidator {
    private static String dateRegex = "\\d{2}-\\d{2}-\\d{4}";

    /**
     * validates the integrity of the PostPromoDTO
     * @param postPromoDto
     * @description
     * @return true if every field of the dto is with the correcto format
     */
    public static boolean validate(PostPromoDto postPromoDto){
        if(postPromoDto.getUser_id().equals(0) || postPromoDto.getUser_id() < 0){
            throw new BadRequestException("El valor de user_id no puede ser menor o igual a cero");
        }

        if(!Pattern.matches(dateRegex, postPromoDto.getDate())){
            throw new BadRequestException("El formato de fecha debe de ser YYYY-MM-DD");
        }else{
            String reversedDate = Dates.reverseDate(postPromoDto.getDate());
            if(LocalDate.parse(reversedDate).isBefore(LocalDate.now())){
                throw new BadRequestException("La fecha de publicacion no puede ser menor a la fecha actual");
            }
        }



        if(postPromoDto.getCategory() <= 0){
            throw new BadRequestException("El id de la categoria no puede ser menor o igual a cero");
        }

        if(postPromoDto.getPrice() <= 0){
            throw new BadRequestException("El precio del producto no puede ser menor o igual a cero");
        }

        if(postPromoDto.isHas_promo() == false){
            throw new BadRequestException("El atributo de has_promo debe de ser true debido a que se desea cargar un promocion");
        }

        if(postPromoDto.getDiscount() <= 0){
            throw new BadRequestException("El descuento no puede ser menor o igual a cero");
        }

        return true;
    }
}
