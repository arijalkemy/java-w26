package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.sprint1.entity.Product;

import java.time.LocalDate;


@Getter
@Setter
@Data
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price", "has_promo", "discount"})
public class PostDTO {
    @JsonProperty("user_id")
    private int sellerId;
    @JsonProperty("post_id")
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
