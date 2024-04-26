package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.MessageResponseDTO;
import com.group03.sprint1.dto.response.PublicationPromoResponseDTO;
import com.group03.sprint1.dto.response.PublicationResponseDTO;
import com.group03.sprint1.dto.response.SellersWithPublicationDTO;

import java.util.List;

public interface IPublicationsService {

    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);
    MessageResponseDTO createPublication(PublicationDTO publicationDTO);
    MessageResponseDTO createPublicationPromo(PublicationDTO publication);
    PublicationPromoResponseDTO getPublicationPromoCount(Integer userId);
    PublicationResponseDTO getPublicationsPromo(Integer userId);
    List<PublicationPromoResponseDTO> getAllPublicationsPromoCount();
    List<PublicationResponseDTO> getPublicationsWithDiscountGreaterThan(Double discount);
    List<SellersWithPublicationDTO> showAllSellers();
}
