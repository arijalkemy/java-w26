package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "user_id",
        "post_id",
        "date",
        "product",
        "category",
        "price",
        "has_promo",
        "discount"
})
public class PostDTO implements Serializable {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("user_id")
    private Integer userId;
    private Date date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
