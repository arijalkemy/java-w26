package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProductPromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", nullable = false)
    private ProductType productType;
    @JsonProperty("product_description")
    private String description;
    @JsonProperty("product_price_original")
    private Double priceOriginal;
    @JsonProperty("product_price_promo")
    private Double pricePromo;
    @JsonProperty("product_start_date")
    private LocalDate startDate;
    @JsonProperty("product_end_date")
    private LocalDate endDate;


}
