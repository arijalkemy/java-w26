package com.mercadolibre.Productos_NOSQL.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String id;
    String name;
    String type;
    Double price_sale;
    Double price_cost;
    Integer cant_disp;
}
