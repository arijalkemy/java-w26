package org.bootcamp.linktracer.service;

import org.bootcamp.linktracer.dto.LinkDTO;
import org.bootcamp.linktracer.dto.ResponseDTO;
import org.bootcamp.linktracer.dto.response.LinkResponseDTO;

public interface LinkService {

    LinkResponseDTO saveLink(LinkDTO linkDTO);

    String getRedirect (Integer id, String password);

    LinkResponseDTO getLinkMetrics (Integer id);

    ResponseDTO invalidateLink (Integer id);


}
