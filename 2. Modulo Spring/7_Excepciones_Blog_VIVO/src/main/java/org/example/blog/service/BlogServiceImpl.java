package org.example.blog.service;

import org.example.blog.dto.EntradaBlogDto;
import org.example.blog.entity.EntradaBlog;
import org.example.blog.exception.EntradaBlogNoEncontradaException;
import org.example.blog.exception.EntradaBlogYaExiste;
import org.example.blog.repository.IBlogRepository;
import org.example.blog.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;


    @Override
    public List<EntradaBlogDto> buscarTodas() {
        return blogRepository.buscarTodos().stream()
            .map(Mapper::mapearADto)
            .toList();
    }

    @Override
    public EntradaBlogDto buscarPorId(int id) {
        return blogRepository.buscarPorId(id)
            .map(Mapper::mapearADto)
            .orElseThrow(() -> new EntradaBlogNoEncontradaException(id));
    }

    @Override
    public void crearEntradaBlog(EntradaBlogDto entradaBlogDto) {

        if (blogRepository.buscarPorId(entradaBlogDto.getId()).isPresent())
            throw new EntradaBlogYaExiste(entradaBlogDto.getId());

        EntradaBlog nuevaEntradaBlog = Mapper.mapearAEntidad(entradaBlogDto);

        blogRepository.guardar(nuevaEntradaBlog);
    }
}
