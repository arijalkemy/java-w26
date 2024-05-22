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
public class ObraLiterariaRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String author;
    @Positive
    @JsonProperty("amount_of_pages")
    private Integer amountOfPages;
    @NotEmpty
    private String editorial;
    @Positive
    @JsonProperty("publishing_year")
    private Integer publishingYear;
}
