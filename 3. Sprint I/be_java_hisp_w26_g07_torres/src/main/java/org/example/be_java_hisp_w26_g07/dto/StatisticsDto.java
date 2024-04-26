package org.example.be_java_hisp_w26_g07.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("posts_by_year")
    private Map<String, Integer> postsByYear;
    @JsonProperty("promo_ratio")
    private PromoRatioDto promoRatio;
    @JsonProperty("posts_by_category")
    private Map<String, Integer> postsByCategory;
}
