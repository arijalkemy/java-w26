package org.example.linktraker.repository;

import org.example.linktraker.dto.request.LinkCrearRequestDto;
import org.example.linktraker.entity.LinkPersonalizado;


public interface ILinkRepository {
    int save(LinkCrearRequestDto link);
    LinkPersonalizado findById(Integer id);
    boolean updateLinkValidez(int linkId, boolean validar);
}

