package org.example.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellersProductsCountDto {
    private int sellerId;
    private String sellerName;
    private int productsPromotionCount;
}
