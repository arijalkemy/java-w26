package com.example.I.Blog.service;

import com.example.I.Blog.dto.EntradaBlogDto;
import com.example.I.Blog.repository.BlogRepositoryImpl;

import java.util.List;

public interface IBlogService {

    Long agregarEntrada(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto obtenerEntrada(Long id);
    List<EntradaBlogDto> obtenerEntradas();

}
