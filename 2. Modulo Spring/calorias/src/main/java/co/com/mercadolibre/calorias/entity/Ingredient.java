package co.com.mercadolibre.calorias.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    private String name;
    private Integer calories;
    private Integer weight;
}
