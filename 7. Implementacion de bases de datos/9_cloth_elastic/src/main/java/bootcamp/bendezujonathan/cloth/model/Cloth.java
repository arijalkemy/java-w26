package bootcamp.bendezujonathan.cloth.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "cloth_")
public class Cloth {

    @Id
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer cantidad;
    private String talle;
    private Double precioVenta;

}
