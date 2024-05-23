package org.ggomezr.showroomelasticsearch.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "clothing")
public class Clothing {
    @Id
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer stock;
    private Double price;
}
