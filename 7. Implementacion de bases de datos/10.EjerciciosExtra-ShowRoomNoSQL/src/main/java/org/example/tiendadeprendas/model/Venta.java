package org.example.tiendadeprendas.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Document(indexName = "venta")
@Setter
@Getter
public class Venta implements Serializable {
    @Id
    String idVenta;
    @Field(type = FieldType.Date)
    private LocalDate fecha;
    String medioPago;
    Double precioTotal;
    @Field(type = FieldType.Nested, includeInParent = true)
    List<Prenda> prendaLista;
}
