package com.example.BlogAnotation.service;

import com.example.BlogAnotation.dto.EntradaBlogDTO;

import java.util.List;

public interface IEntradaBlogService {

    public String crearEntradaBlog(EntradaBlogDTO entradaBlog);

    public EntradaBlogDTO obtenerBlogPorId(Integer id);

    public List<EntradaBlogDTO> obtenerTodosBlogs();

}
