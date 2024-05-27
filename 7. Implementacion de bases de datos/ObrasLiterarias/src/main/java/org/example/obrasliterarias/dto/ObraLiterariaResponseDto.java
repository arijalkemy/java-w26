package org.example.obrasliterarias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaResponseDto {
    private String id;
    private String name;
    private String author;
    @JsonProperty("amount_of_pages")
    private Integer amountOfPages;
    private String editorial;
    @JsonProperty("publishing_year")
    private Integer publishingYear;
}
