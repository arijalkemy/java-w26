package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.be_java_hisp_w26_g04.model.Product;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({"idPost", "userId", "date", "category", "price", "product", "hasPromo", "discount"})
public class PostResponseDTO {
    @JsonProperty("post_id")
    @JsonAlias("idPost")
    private int idPost;
    @JsonProperty("user_id")
    @JsonAlias("userId")
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private double price;
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("has_promo")
    @JsonAlias("hasPromo")
    private boolean hasPromo;
    private double discount;
}
