package org.example.literary_works.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
public class LiteraryWorkResDto {
    private String id;
    private String title;
    private String author;
    @JsonProperty("pages_quantity")
    private Integer pagesQuantity;
    private String publisher;
    @JsonProperty("year_first_publication")
    private Integer yearFirstPublication;
}
