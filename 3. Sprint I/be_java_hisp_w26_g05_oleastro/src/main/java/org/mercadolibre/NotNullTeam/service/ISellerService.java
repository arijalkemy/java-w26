package org.mercadolibre.NotNullTeam.service;

import org.mercadolibre.NotNullTeam.DTO.response.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.SellerResponseDTO;

public interface ISellerService {
    SellerFollowersCountDto getFollowersCount(Long userId);

    SellerResponseDTO getListFollowers(Long userId);

    SellerResponseDTO getListFollowersOrdered(Long userId, String order);
}
