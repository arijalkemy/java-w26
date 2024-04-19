package com.example.ejercicioBlog.service.impl;

import com.example.ejercicioBlog.dto.EntradaBlogDto;
import com.example.ejercicioBlog.exceptions.BadRequestException;
import com.example.ejercicioBlog.exceptions.NotFoundException;
import com.example.ejercicioBlog.model.EntradaBlog;
import com.example.ejercicioBlog.repository.impl.BlogRepositoryImpl;
import com.example.ejercicioBlog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogRepositoryImpl blogRepository;

    @Override
    public List<EntradaBlogDto> getAll() {
        List<EntradaBlogDto> entries = blogRepository.getAll();

        if( entries.isEmpty() ){
            throw new NotFoundException("No existen entradas de blog");
        }
        return entries;
    }

    @Override
    public EntradaBlogDto findById(Integer id) {
        EntradaBlogDto findElement = blogRepository.findById( id );

        if( findElement == null ){
            throw new NotFoundException("The element with id " + id + " does not exist");
        }
        return findElement;
    }

    @Override
    public String save(EntradaBlog entradaBlog) {
        boolean isSaved = blogRepository.save( entradaBlog.getId(), new EntradaBlogDto(entradaBlog) );

        if( !isSaved ){
            throw new BadRequestException("The ID " + entradaBlog.getId() + " already exists");
        }
        return "Save successful, id: " + entradaBlog.getId();
    }
}
