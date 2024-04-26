package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.be_java_hisp_w26_g07.entity.Product;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoRequestDto {
    @NotNull
    @JsonProperty("user_id")
    private Integer userId;
    @NotNull
    @PastOrPresent
    @JsonProperty("date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    @NotNull
    @JsonProperty("product")
    private Product product;
    @NotNull
    @JsonProperty("category")
    private Integer category;
    @NotNull
    @JsonProperty("price")
    private Double price;
    @NotNull
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @NotNull
    @JsonProperty("discount")
    private Double discount;
}
