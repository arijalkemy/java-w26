package com.bootcamp.c4blog.service;

import com.bootcamp.c4blog.dto.BlogRequestDTO;
import com.bootcamp.c4blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.c4blog.exception.EntityExistException;

import java.util.List;


public interface IBlogService {

    Integer crearEntrada(BlogRequestDTO blogDTO) throws EntityExistException;
    List<EntradaBlogResponseDTO> obtenerEntradas();

    EntradaBlogResponseDTO obtenerEntrada(Integer id);
}
