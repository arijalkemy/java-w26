package org.responseentity.linktracker.mapper;

import org.responseentity.linktracker.dto.LinkDTO;
import org.responseentity.linktracker.dto.LinkInvalidateDTO;
import org.responseentity.linktracker.dto.LinkMetricDTO;
import org.responseentity.linktracker.entity.LinkEntity;

public class LinkMapper {
    public static LinkDTO entityToDTO(LinkEntity linkEntity){
        return LinkDTO.builder()
                .id(linkEntity.getId())
                .source(linkEntity.getSource())
                .build();
    }

    public static LinkMetricDTO entityToMetricDTO(LinkEntity linkEntity){
        return LinkMetricDTO.builder()
                .id(linkEntity.getId())
                .source(linkEntity.getSource())
                .noRedirects(linkEntity.getNumberOfRedirects())
                .build();
    }

    public static LinkInvalidateDTO entityToInvalidateDTO(LinkEntity linkEntity, String message){
        return LinkInvalidateDTO
                .builder()
                .id(linkEntity.getId())
                .source(linkEntity.getSource())
                .message(message)
                .build();
    }
}
