package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDto {
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private String category;
    private String price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
    private ProductDto product;


}
