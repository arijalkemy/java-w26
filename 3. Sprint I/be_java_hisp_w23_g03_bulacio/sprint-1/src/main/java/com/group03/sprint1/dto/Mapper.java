package com.group03.sprint1.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.entity.Publication;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static List<PublicationDTO> mapPublicationListToDTO(List<Publication> publications) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return publications.stream().map(
                p-> objectMapper.convertValue(p, PublicationDTO.class)
        ).collect(Collectors.toList());
    }
}
