package Ejercicio.ElasticSearch.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import java.time.LocalDate;

@Data
@Document(indexName = "literary_work")
public class LiteraryWork {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String author;

    @Field
    private String editorial;

    @Field
    private Integer pages;

    @Field
    private LocalDate publicationDate;
}
