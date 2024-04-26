package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.PublicationListDTO;
import com.group03.sprint1.dto.response.SellerPromotionCountResponseDTO;

import java.util.List;

public interface IPublicationsService {
    SellerPromotionCountResponseDTO countPublicationsInPromotionForSeller(Integer userId);
    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);

    PublicationListDTO getAllPublications(String productName, Double minTotal, Double maxTotal, String order);
}
