package com.implementaciondb.ejercicio9_obras_literarias.model.domain;

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
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String author;

    @Field(type = FieldType.Integer, name = "number_pages")
    private Integer numberPages;

    @Field(type = FieldType.Text, name = "editorial")
    private String editoria;

    @Field(type = FieldType.Integer, name = "year_publication")
    private Integer yearPublication;
}
