package com.w26.elasticsearch.elasticsearch.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO implements Serializable {
    @NotBlank
    private String name;

    @NotBlank
    private String type;
    
    @NotNull
    private Double priceOfSell;
    
    @NotNull
    private Integer countAvailble;
}
