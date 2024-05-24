package org.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestJewelryDTO {
    private String name;
    private String material;
    private float weight;
    private String particularity;
    boolean haveStone;
}
