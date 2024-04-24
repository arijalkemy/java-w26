package org.example.blog.service;

import org.example.blog.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {
    List<EntradaBlogDto> buscarTodas();
    EntradaBlogDto buscarPorId(int id);
    void crearEntradaBlog(EntradaBlogDto entradaBlogDto);
}
