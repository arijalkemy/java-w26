package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonProperty("category")
    private int category;

    @JsonProperty("price")
    private double price;

    @JsonProperty("product")
    private ProductDTO product;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;
}
