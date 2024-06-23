package org.example.productoelastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.productoelastic.entity.Tipo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String id;
    private String nombre;
    private Tipo tipo;
    private Double precio_venta;
    private Double precio_costo;
    private Integer cantidad_disponible;
}
