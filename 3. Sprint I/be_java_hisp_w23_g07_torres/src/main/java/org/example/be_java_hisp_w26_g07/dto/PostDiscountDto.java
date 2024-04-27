package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDiscountDto {
    @NotNull
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer id;
    @NotNull
    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    @NotNull
    @JsonProperty("product")
    private ProductDto product;
    @NotNull
    @JsonProperty("category")
    private Integer category;
    @NotNull
    @JsonProperty("price")
    private double price;
    @NotNull
    @JsonProperty("has_promo")
    private Boolean has_promo;
    @NotNull
    @JsonProperty("discount")
    private Double discount;
}
