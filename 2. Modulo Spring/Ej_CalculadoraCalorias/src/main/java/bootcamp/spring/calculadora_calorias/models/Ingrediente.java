package bootcamp.spring.calculadora_calorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente {
    private String nombre;
    private Integer calorias;
}
