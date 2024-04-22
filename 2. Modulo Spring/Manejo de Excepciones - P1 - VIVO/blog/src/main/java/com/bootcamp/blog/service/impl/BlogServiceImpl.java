package com.bootcamp.blog.service.impl;

import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exception.AlreadyExistException;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.repository.EntradasBlogRepository;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private EntradasBlogRepository entradasBlogRepository;


    @Override
    public EntradaBlog crearEntrada(EntradaBlog entradaBlog) {
        if (entradasBlogRepository.existsById(entradaBlog.getId())) {
            throw new AlreadyExistException("Ya existe una entrada con ese id");
        }
        return entradasBlogRepository.save(entradaBlog);
    }

    @Override
    public EntradaBlog obtenerEntrada(Integer id) {
        if (!entradasBlogRepository.existsById(id)) {
            throw new NotFoundException("No se encontro una entrada con ese id");
        }
        return entradasBlogRepository.findById(id);
    }

    @Override
    public HashMap<Integer, EntradaBlog> obtenerEntradas() {
        return entradasBlogRepository.findAll();
    }
}
