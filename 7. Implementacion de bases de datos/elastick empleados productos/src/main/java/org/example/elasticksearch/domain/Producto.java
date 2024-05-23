package org.example.elasticksearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName="productos")
public class Producto{
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String tipo;
    @Field(type = FieldType.Double)
    private double precioVenta;
    @Field(type = FieldType.Double, name = "precio_costo")
    private double precioCosto;
    @Field(type = FieldType.Double, name = "cantidad_disponible")
    private int cantidadDisponible;
}