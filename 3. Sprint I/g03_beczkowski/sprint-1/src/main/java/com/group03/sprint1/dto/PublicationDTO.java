package com.group03.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    @JsonIgnore(value = false)
    private boolean hasPromo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;
}
