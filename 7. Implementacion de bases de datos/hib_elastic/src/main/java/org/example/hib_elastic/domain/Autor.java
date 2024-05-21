package org.example.hib_elastic.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "author")
public class Autor {
    private String nombre;
}
