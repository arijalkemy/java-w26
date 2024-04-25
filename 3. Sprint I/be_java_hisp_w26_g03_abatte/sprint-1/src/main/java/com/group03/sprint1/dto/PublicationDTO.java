package com.group03.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO implements Serializable {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean has_promo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double discount;
}
