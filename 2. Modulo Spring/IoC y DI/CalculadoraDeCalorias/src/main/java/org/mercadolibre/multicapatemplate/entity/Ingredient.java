package org.mercadolibre.multicapatemplate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Ingredient {
    private String name;
    private int calories;
}
