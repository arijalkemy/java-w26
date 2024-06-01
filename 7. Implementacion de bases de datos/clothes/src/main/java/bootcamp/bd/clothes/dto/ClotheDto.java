package bootcamp.bd.clothes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class ClotheDto {
    private String name;
    private String type;
    private String brand;
    private Integer size;
    private Integer stock;
    private Double price;
}
