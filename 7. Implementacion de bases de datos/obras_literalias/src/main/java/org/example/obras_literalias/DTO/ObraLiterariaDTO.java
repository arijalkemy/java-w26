package org.example.obras_literalias.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObraLiterariaDTO {
    private String name;
    private String author;
    private Integer amountOfPages;
    private String editorial;
    private Integer publishingYear;
}
