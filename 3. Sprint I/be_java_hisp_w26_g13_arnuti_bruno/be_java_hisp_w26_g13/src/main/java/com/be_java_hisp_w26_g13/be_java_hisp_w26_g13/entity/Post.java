package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
public class Post {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("user_id")
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean has_promo = false;
    private Double discount = 0.0;
}
