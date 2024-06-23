package com.mercadolibre.project_be_java_hisp_w26_team5.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailResponseDto  {
    Integer id;
    String name;
    String description;
    TypeProduct type;
    @JsonProperty("creation_date")
    Instant creationDate;
}