package co.com.mercadolibre.miniseries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieDTO {

    private Long id;
    private String name;
    private Double rating;
    private Integer amountOfAwards;
}
