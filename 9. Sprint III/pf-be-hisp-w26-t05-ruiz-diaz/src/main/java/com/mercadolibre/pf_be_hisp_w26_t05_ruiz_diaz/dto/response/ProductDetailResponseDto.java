package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
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