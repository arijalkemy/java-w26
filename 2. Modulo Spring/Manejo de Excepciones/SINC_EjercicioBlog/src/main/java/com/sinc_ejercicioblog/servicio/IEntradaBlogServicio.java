package com.sinc_ejercicioblog.servicio;

import com.sinc_ejercicioblog.dto.EntradaBlogDTO;

import java.util.List;

public interface IEntradaBlogServicio {
    String crearEntradaBlog(EntradaBlogDTO entradaBlogDTO);

    EntradaBlogDTO buscarEntradaBlogPorId(int id);

    List<EntradaBlogDTO> buscarTodosLosBlogs();
}
