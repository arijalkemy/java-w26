package org.responseentity.productos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "productos")
public class Producto {
    @Id
    private String id;

    private String nombre;
    private String tipo;
    private Long precioVenta;
    private Long precioCosto;
    private Integer cantidadDisponible;
}
