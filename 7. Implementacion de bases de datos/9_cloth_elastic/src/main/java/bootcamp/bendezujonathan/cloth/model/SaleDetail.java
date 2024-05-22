package bootcamp.bendezujonathan.cloth.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetail {


    @Id
    private Long id;
    private double precioIndividual;
    private Integer cantidad;

    @Field(type = FieldType.Nested, includeInParent = true)
    private  Cloth cloth;

    public Double calculateSubTotal(){
        return  cantidad * precioIndividual;
    }

}
