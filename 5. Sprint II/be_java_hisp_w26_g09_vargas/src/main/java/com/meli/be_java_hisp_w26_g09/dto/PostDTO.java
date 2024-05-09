package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@Builder
public class PostDTO implements Serializable {
    @JsonProperty("post_id")
    @NotNull
    @Min(1)
    private Integer postId;

    @JsonProperty("user_id")
    @NotNull
    @Min(1)
    private Integer userId;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Date is required, can't be null")
    private LocalDate date;

    @Valid
    @NotNull
    private ProductDTO product;

    @NotNull(message = "Category is required, can't be null")
    private Integer category;

    @NotNull(message = "Price is required, can't be null")
    @Max(value = 10000000, message = "Max price is $10.000.000")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

}