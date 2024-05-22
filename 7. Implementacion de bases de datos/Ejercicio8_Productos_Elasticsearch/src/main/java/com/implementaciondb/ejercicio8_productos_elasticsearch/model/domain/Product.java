package com.implementaciondb.ejercicio8_productos_elasticsearch.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleados")
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String tipo;

    @Field(type = FieldType.Double, name = "precio_venta")
    private Double precioVenta;

    @Field(type = FieldType.Double, name = "precio_costo")
    private Double precioCosto;

    @Field(type = FieldType.Integer, name = "cantidad_disponible")
    private Integer cantidadDisponible;

}
