package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.sprint1.entity.Product;

import java.time.LocalDate;


@Getter
@Setter
@NotNull
public class PostDTO {
    @NotNull
    @JsonProperty("user_id")
    private int sellerId;
    @NotNull
    @JsonProperty("post_id")
    private int postId;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private String date;
    @NotNull
    private Product product;
    @NotNull
    private int category;
    @NotNull
    private double price;
    @NotNull
    @JsonProperty("has_promo")
    private boolean hasPromo;
    @NotNull
    private double discount;
}
