package meli.bootcamp.elastictest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;

    private String title;

    private List<Author> authors;
}
