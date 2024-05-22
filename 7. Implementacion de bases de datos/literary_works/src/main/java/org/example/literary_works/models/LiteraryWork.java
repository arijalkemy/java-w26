package org.example.literary_works.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "literary_work")
public class LiteraryWork {
    @Id
    private String id;
    private String title;
    private String author;
    @Field(name = "pages_quantity")
    private int pagesQuantity;
    private String publisher;
    @Field(name = "year_first_publication")
    private int yearFirstPublication;
}
