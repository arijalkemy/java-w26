package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.MessageResponseDTO;
import com.group03.sprint1.dto.response.PublicationPromoCountResponseDTO;
import com.group03.sprint1.dto.response.PublicationResponseDTO;
import com.group03.sprint1.dto.response.SellersWithPublicationDTO;

import java.util.List;

public interface IPublicationsService {

    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);
    List<SellersWithPublicationDTO> showAllSellers();
    MessageResponseDTO createPublication(PublicationDTO publicationDTO);
    MessageResponseDTO createPublicationWithPromotion(PublicationDTO publicationDTO);
    PublicationPromoCountResponseDTO getPublicationPromoCount(Integer userId);
    PublicationResponseDTO getPublicationsPromo(Integer userId);
}
