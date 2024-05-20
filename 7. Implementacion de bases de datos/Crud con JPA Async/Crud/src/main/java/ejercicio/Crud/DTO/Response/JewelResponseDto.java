package ejercicio.Crud.DTO.Response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JewelResponseDto {
    private Long id;

    private String name;

    private String material;

    private boolean hasStone;

    private double Weight;

    private String particularity;

    private boolean soldOrNot;
}
