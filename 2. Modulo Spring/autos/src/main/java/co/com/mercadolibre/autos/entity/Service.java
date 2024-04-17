package co.com.mercadolibre.autos.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Service {

    private String date;
    private String kilometers;
    private String descriptions;
}
