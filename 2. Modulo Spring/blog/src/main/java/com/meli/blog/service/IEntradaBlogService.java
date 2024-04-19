package com.meli.blog.service;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.dto.MensajeDTO;

import java.util.List;

public interface IEntradaBlogService {
    MensajeDTO crearEntrada(EntradaBlogDTO entradaBlog);

    EntradaBlogDTO getEntrada(String id);

    List<EntradaBlogDTO> getListaEntradas();
}
