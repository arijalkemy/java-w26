package bootcamp.bendezujonathan.elastichsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(indexName = "test")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    
    @Id
    private Long id;

    private String titulo;

}
