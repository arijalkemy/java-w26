package com.api.socialmeli.validators;

import com.api.socialmeli.dto.ProductDto;
import com.api.socialmeli.exception.BadRequestException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDtoValidator {
    private static List<String> colorsAllowed = new ArrayList<>(
            Arrays.asList(
                    "red", "blue", "green", "yellow", "pink", "grey"
            )
    );

    private static List<String> typesAllowed = new ArrayList<>(
            Arrays.asList(
                    "kitchen", "men", "woman", "children", "bakery", "shoes", "gamer", "pc"
            )
    );

    private static List<String> brandAllowed = new ArrayList<>(
            Arrays.asList(
                    "nike", "bimbo", "xiaomi", "kellogs", "under armor", "racer", "nvidia", "amd"
            )
    );

    /**
     * validates the integrity of the Product DTO
     * @param productDto
     * @return true if every field of the dto is with the correct format
     */
    public static boolean validate(ProductDto productDto){
        if(productDto.getProduct_id().equals(0) || productDto.getProduct_id() < 0){
            throw new BadRequestException("El id del producto no puede ser menor o igual a cero");
        }

        if(productDto.getProduct_name().isEmpty() || productDto.getProduct_name().isEmpty()){
            throw new BadRequestException("El nombre del producto no puede ir vacio");
        }

        if(productDto.getBrand().isEmpty() || productDto.getBrand().isEmpty()){
            throw new BadRequestException("La marca del producto no puede ir vacia");
        }

        if(!brandAllowed.contains(productDto.getBrand().toLowerCase())){
            throw new BadRequestException("La marca no esta dentro de las permitidas");
        }

        if(productDto.getType().isEmpty() || productDto.getType().isBlank()){
            throw new BadRequestException("El tipo de producto no puede ir vacio");
        }

        if(!colorsAllowed.contains(productDto.getColor().toLowerCase())){
            throw new BadRequestException("El color no esta en la lista permitida");
        }

        if(productDto.getColor().isEmpty() || productDto.getColor().isBlank()){
            throw new BadRequestException("El color del producto no puede ir vacio");
        }

        if(!colorsAllowed.contains(productDto.getColor().toLowerCase())){
            throw new BadRequestException("El color no se encuetra dentro de los permitidos");
        }

        if(productDto.getNotes().isBlank() || productDto.getNotes().isEmpty()){
            throw new BadRequestException("Las notas no puden ir vacias");
        }

        return true;
    }
}
