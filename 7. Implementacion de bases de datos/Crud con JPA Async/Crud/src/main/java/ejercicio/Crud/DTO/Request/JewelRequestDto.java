package ejercicio.Crud.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelRequestDto {
    private String name;

    private String material;

    private boolean hasStone;

    private double weight;

    private String particularity;
}
