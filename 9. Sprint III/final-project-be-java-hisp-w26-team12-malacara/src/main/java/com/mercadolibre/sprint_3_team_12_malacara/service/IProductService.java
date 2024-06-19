package com.mercadolibre.sprint_3_team_12_malacara.service;

import com.mercadolibre.sprint_3_team_12_malacara.dto.response.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);
    ResponseProductDTO getProductsBySeller(Long userId);
    ResponseProductDTO getProductsBySellerAndByQuantity(Long userId, double quantity);
}
