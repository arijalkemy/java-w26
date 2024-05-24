package org.example.obras_literalias.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obra_literaria")
public class ObraLiteraria {
    @Id
    private String id;
    private String name;
    private String author;
    private Integer amountOfPages;
    private String editorial;
    private Integer publishingYear;
}
