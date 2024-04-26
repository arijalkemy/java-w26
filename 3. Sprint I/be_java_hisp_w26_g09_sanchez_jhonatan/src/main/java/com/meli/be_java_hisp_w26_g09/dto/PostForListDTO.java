package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostForListDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private ProductDTO product;
    private Integer category;
    private Double price;

    public PostForListDTO(Integer userId, Integer postId, Date date, ProductDTO product, Integer category, Double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
