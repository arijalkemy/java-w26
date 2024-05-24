package org.example.obrasliterarias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obra_literaria")
public class ObraLiteraria {
    @Id
    private String id;
    private String name;
    private String author;
    @JsonProperty("amount_of_pages")
    @Field(name = "amount_of_pages")
    private Integer amountOfPages;
    private String editorial;
    @JsonProperty("publishing_year")
    @Field(name = "publishing_year")
    private Integer publishingYear;
}
