package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoPostSetDTO {

    @JsonProperty("post_id")
    private int postId;

    private double discount;
}
