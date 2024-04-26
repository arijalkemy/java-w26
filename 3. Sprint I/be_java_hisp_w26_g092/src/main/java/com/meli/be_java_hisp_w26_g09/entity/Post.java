package com.meli.be_java_hisp_w26_g09.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    private Date date;
    private Product product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
