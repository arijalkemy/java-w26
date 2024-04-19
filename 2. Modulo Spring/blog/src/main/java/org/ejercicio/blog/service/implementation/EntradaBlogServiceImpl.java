package org.ejercicio.blog.service.implementation;

import org.ejercicio.blog.dto.EntradaBlogDTO;
import org.ejercicio.blog.dto.EntradaBlogResponseDTO;
import org.ejercicio.blog.entity.EntradaBlog;
import org.ejercicio.blog.exceptions.BlogAlreadyExistsException;
import org.ejercicio.blog.exceptions.BlogNotFoundException;
import org.ejercicio.blog.repository.IEntradaBlogRepository;
import org.ejercicio.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService {

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    @Override
    public List<EntradaBlogResponseDTO> buscarTodos() {
        List<EntradaBlog> entradaBlogs = entradaBlogRepository.buscarTodos();
        return entradaBlogs.stream().map(e->
                new EntradaBlogResponseDTO(e.getId(), e.getTitulo(),e.getNombreAutor(),e.getFechaPublicacion())
                ).toList();
    }

    @Override
    public EntradaBlogResponseDTO buscarPorId(int id) {
        EntradaBlog entradaBlog= entradaBlogRepository.buscarPorId(id);
        if(entradaBlog==null) {
            throw new BlogNotFoundException("No se encontro el blog con id "+id);
        }
        EntradaBlogResponseDTO entradaBlogResponseDTO = new EntradaBlogResponseDTO(entradaBlog.getId(),
                entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
        return entradaBlogResponseDTO;
    }

    @Override
    public EntradaBlogResponseDTO agregarBlog(EntradaBlogDTO entradaBlogDTO) {
        if(entradaBlogRepository.buscarPorId(entradaBlogDTO.getId())!=null)
            throw new BlogAlreadyExistsException("El libro con id "+entradaBlogDTO.getId()+" ya existe en el sistema");
        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDTO.getId(),entradaBlogDTO.getTitulo(),
                entradaBlogDTO.getNombreAutor());
        entradaBlogRepository.agregarBlog(entradaBlog);
        return new EntradaBlogResponseDTO(entradaBlog.getId(),
                entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }
}
