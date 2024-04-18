package com.bootcamp.c4blog.service;

import com.bootcamp.c4blog.dto.BlogRequestDTO;
import com.bootcamp.c4blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.c4blog.exception.EntityExistException;
import com.bootcamp.c4blog.model.EntradaBlog;
import com.bootcamp.c4blog.repository.LibrosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    LibrosRepository librosRepository;
    @Override
    public Integer crearEntrada(BlogRequestDTO blogDTO)  {

        if(librosRepository.existeEntrada(blogDTO.getId())){
            throw new EntityExistException("Error al crear la entrada");
        }

        return librosRepository.agregarEntrada(new EntradaBlog(blogDTO.getId(), blogDTO.getTitulo(), blogDTO.getNombreAutor(),
                blogDTO.getFechaPublicacion()));
    }

    @Override
    public List<EntradaBlogResponseDTO> obtenerEntradas() {
        ObjectMapper objectMapper = new ObjectMapper();

        List<EntradaBlogResponseDTO> response = librosRepository.obtenerTodasLasEntradas().stream()
                .map(entradaBlog -> objectMapper.convertValue( entradaBlog, EntradaBlogResponseDTO.class)).toList();
        return response;
    }

    @Override
    public EntradaBlogResponseDTO obtenerEntrada(Integer id) {

        ObjectMapper objectMapper = new ObjectMapper();
        EntradaBlog entradaBlog = librosRepository.buscarEntrada(id);

        return objectMapper.convertValue(entradaBlog, EntradaBlogResponseDTO.class);


    }

}
