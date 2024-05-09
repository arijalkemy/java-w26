package com.group03.sprint2.service;

import com.group03.sprint2.dto.PublicationDTO;

import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellersWithPublicationDTO;

import java.util.List;

public interface IPublicationsService {

    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);
    List<SellersWithPublicationDTO> showAllSellers();
    MessageResponseDTO createPublication(PublicationDTO publicationDTO);
}
