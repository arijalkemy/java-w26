package org.example.literary_works.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LiteraryWorkDto {
    private String title;
    private String author;
    @JsonProperty("pages_quantity")
    private Integer pagesQuantity;
    private String publisher;
    @JsonProperty("year_first_publication")
    private Integer yearFirstPublication;
}
