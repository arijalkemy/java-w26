package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.*;
import org.example.SocialMeli2.entity.Product;

import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    private int sellerId;
    @JsonProperty("post_id")
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @Valid
    private Product product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
