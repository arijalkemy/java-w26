package bootcamp.bd.clothes.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bd.clothes.dto.ClotheDto;
import bootcamp.bd.clothes.model.Clothe;

public class ClotheMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private ClotheMapper(){}

    public static Clothe dtoToEntity(ClotheDto clotheDto){
        return MAPPER.convertValue(clotheDto, Clothe.class);
    }

    public static ClotheDto entityToDto(Clothe clothe){
        return ClotheDto
            .builder()
            .name(clothe.getName())
            .type(clothe.getType())
            .brand(clothe.getBrand())
            .size(clothe.getSize())
            .stock(clothe.getStock())
            .price(clothe.getPrice())
            .build();
    }

    public static void modifyClothe(ClotheDto newClothe, Clothe oldClothe){
        oldClothe.setName(newClothe.getName());
        oldClothe.setType(newClothe.getType());
        oldClothe.setBrand(newClothe.getBrand());
        oldClothe.setSize(newClothe.getSize());
        oldClothe.setStock(newClothe.getStock());
        oldClothe.setPrice(newClothe.getPrice());
    }
}
