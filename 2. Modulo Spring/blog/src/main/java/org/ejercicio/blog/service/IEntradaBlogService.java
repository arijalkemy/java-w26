package org.ejercicio.blog.service;

import org.ejercicio.blog.dto.EntradaBlogDTO;
import org.ejercicio.blog.dto.EntradaBlogResponseDTO;
import org.ejercicio.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogResponseDTO> buscarTodos();
    EntradaBlogResponseDTO buscarPorId(int id);
    EntradaBlogResponseDTO agregarBlog(EntradaBlogDTO entradaBlogDTO);
}
