package org.example.be_java_hisp_w26_g07.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer id;
    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("category")
    private String category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("has_promo")
    @NotNull
    private boolean hasPromo;
    @JsonProperty("discount")
    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("1")
    private double discount;

}
