package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    @JsonProperty("discount")
    private double discount;
}
