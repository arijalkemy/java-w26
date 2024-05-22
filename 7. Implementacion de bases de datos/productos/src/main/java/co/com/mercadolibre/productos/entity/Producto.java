package co.com.mercadolibre.productos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "producto")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precioDeVenta;
    private Double precioDeCosto;
    private Integer cantidadDisponible;
}
