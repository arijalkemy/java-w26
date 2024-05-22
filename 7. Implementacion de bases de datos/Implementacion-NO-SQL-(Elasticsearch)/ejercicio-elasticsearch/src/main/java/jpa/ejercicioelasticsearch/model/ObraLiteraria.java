package jpa.ejercicioelasticsearch.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras_literarias")
@Data
@Builder
public class ObraLiteraria {

    @Id
    private String id;

    private String name;

    private String author;

    private Integer numberPages;

    private String editorial;

    private Integer yearPublication;


}
