package com.EjercicioSpring.Ejercicio13_LinkTracker.service.interfaces;

import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkIdResponseDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkRequestDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkResponseDTO;


public interface ILinkService {

    public LinkIdResponseDTO createLink(LinkRequestDTO linkRequestDTO);

    public String redirect(Integer linkId, String password);

    public LinkResponseDTO getMetrics(Integer linkId);

    public boolean invalidateLink(Integer linkId);

}
