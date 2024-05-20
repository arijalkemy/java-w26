package org.example.joyeria.dto.jewel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelResponseDto {
    private Long id;
    private String name;
    private String source;
    private Double weight;
    private String specificity;
    private Boolean stone;
    private Boolean sell;
}
