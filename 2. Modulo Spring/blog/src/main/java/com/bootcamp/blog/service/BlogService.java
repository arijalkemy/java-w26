package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDto;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exception.BadRequestException;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.repository.BlogRepository;
import com.bootcamp.blog.service.interfaces.IBlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<EntradaBlogDto> getAll() {

        List< EntradaBlog > listEntradasBlog = blogRepository.getAll();

        List<EntradaBlogDto> listEntradaBlogDto = listEntradasBlog.stream().map( e -> mapearEntradaBlogADto(e)).toList();

        return listEntradaBlogDto;
    }

    @Override
    public EntradaBlogDto getById(int id) {

        EntradaBlog entradaBlog = blogRepository.getById(id);

        if(entradaBlog == null) throw new NotFoundException("No existe una entrada de blog con el id: "+id);

        return this.mapearEntradaBlogADto(entradaBlog);
    }

    @Override
    public String create(EntradaBlogDto entradaBlogDto) {

        boolean existe = blogRepository.existeEntrada(entradaBlogDto.getId());

        if(existe) throw new BadRequestException("Ya existe un registro con el id: "+ entradaBlogDto.getId());

        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(entradaBlogDto.getId());
        entradaBlog.setTitulo(entradaBlogDto.getTitulo());
        entradaBlog.setNombreAutor(entradaBlogDto.getNombreAutor());
        entradaBlog.setFechaDeCreacion(entradaBlogDto.getFechaDePublicacion());

        EntradaBlog entradaBlogCreado = blogRepository.create(entradaBlog);

        return "Se creó correctamente la entrada de blog con id: "+ entradaBlogCreado.getId();
    }

    private EntradaBlogDto mapearEntradaBlogADto(EntradaBlog e){
        EntradaBlogDto entradaBlogDto = new EntradaBlogDto();
        entradaBlogDto.setId(e.getId());
        entradaBlogDto.setTitulo(e.getTitulo());
        entradaBlogDto.setNombreAutor(e.getNombreAutor());
        entradaBlogDto.setFechaDePublicacion(e.getFechaDeCreacion());
        return entradaBlogDto;
    }

}
