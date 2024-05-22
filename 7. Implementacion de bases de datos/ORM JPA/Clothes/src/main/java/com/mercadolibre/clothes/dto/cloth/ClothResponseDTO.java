package com.mercadolibre.clothes.dto.cloth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class ClothResponseDTO extends ClothRequestDTO implements Serializable {
    private Long code;

    public ClothResponseDTO(Long code, String name, String type, String brand, String color, Integer size, Integer quantity, Double price) {
        super(name, type, brand, color, size, quantity, price);
        this.code = code;
    }
}
