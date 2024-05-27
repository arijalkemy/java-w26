package com.meli.obras_literarias_VIVO.service;

import com.meli.obras_literarias_VIVO.dtos.RequestObraDto;
import com.meli.obras_literarias_VIVO.dtos.ResponseObraDto;

import java.util.List;

public interface ObraService {
    public String guardObras(List<RequestObraDto> obras);
    public List<ResponseObraDto> getObras();
    public List<ResponseObraDto> getByAutor(String autor);
    public List<ResponseObraDto> getObrasByTitulo(String titulo);
    public List<ResponseObraDto> getTopFiveByPages();
    public List<ResponseObraDto> getAfterAge(Integer año);
}
