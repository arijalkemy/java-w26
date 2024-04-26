package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProductsDto {
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("count")
    private Integer categoryCount;
}
