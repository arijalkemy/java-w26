package com.example.ejercicio_recapitulando_spring_p2_vivo.service;

import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkRequestDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.CreateLinkResponseDto;
import com.example.ejercicio_recapitulando_spring_p2_vivo.dto.LinkDto;

public interface ILinkService {
    public CreateLinkResponseDto createLink(CreateLinkRequestDto createLinkRequestDto);
    LinkDto redirect(Integer linkId);
    LinkDto redirect(Integer linkId, String password);
    int getMetrics(Integer linkId);
    void invalidate(Integer linkId);
}
