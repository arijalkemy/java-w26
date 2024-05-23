package org.ggomezr.obrasliterarias.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "literary_works")
public class LiteraryWork {
    private String id;
    private String title;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer releaseDateYear;
}
