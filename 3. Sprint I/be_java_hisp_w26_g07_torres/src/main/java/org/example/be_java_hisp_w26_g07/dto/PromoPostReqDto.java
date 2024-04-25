package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoPostReqDto{
    @NotNull
    @JsonProperty("user_id")
    @Positive(message = "El valor debe ser positivo")
    private Integer userId;
    @NotNull
    @PastOrPresent
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    @NotNull
    private ProductDto product;
    @NotNull
    @Positive(message = "El valor debe ser positivo")
    private Integer category;
    @NotNull
    @Positive(message = "El valor debe ser positivo")
    private double price;
    @NotNull
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @NotNull
    @Positive(message = "El valor debe ser positivo")
    private Double discount;
}
