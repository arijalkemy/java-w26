package org.example.be_java_hisp_w26_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoProductsCountDTO {
    private int userId;
    private String userName;
    private long promoProductsCount;
}

