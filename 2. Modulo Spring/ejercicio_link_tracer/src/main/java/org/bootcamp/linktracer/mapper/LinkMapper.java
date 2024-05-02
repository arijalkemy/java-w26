package org.bootcamp.linktracer.mapper;

import org.bootcamp.linktracer.dto.LinkDTO;
import org.bootcamp.linktracer.entity.Link;

public class LinkMapper {

    private LinkMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Link linkDTOToLink (LinkDTO linkDTO){
        if(linkDTO == null)
            return new Link();

        return new Link(
                linkDTO.getId(),
                linkDTO.getVisitAmount(),
                linkDTO.getUrl(),
                linkDTO.getValidUrl(),
                linkDTO.getPassword());
    }

}
