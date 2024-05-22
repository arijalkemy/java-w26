package bootcamp.bendezujonathan.cloth.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "cloth_")
public class Sale {

    @Id
    private long numero;
    private LocalDate fecha;
    private double total;
    private String medioDePago;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<SaleDetail> saleDetails;


}
