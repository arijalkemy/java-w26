package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostPromoRequestDto {
    @JsonProperty("user_id")
    @NotNull
    private Integer userId;

    @PastOrPresent
    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("product")
    @NotNull
    private ProductDto product;
    @JsonProperty("category")
    @NotNull
    private String category;
    @JsonProperty("price")
    @NotNull
    private Double price;
    @JsonProperty("has_promo")
    @NotNull
    private boolean hasPromo;
    @JsonProperty("discount")
    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("1")
    private Double discount;
}
