package com.example.blog.service;

import com.example.blog.exception.IdAlreadyInUseException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.model.EntradaBlog;
import com.example.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaServiceImpl implements IEntradaBlog{

    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    @Override
    public Integer crearBlog(EntradaBlog entradaBlog) {
        List<EntradaBlog> entradas = obtenerTodos();
        for(EntradaBlog entrada: entradas){
            if(entradaBlog.getId().equals(entrada.getId()))
                throw new IdAlreadyInUseException("Blog con entrada " + entradaBlog.getId() + " ya existe");
        }
        return entradaBlogRepository.crearBlog(entradaBlog);
    }

    @Override
    public EntradaBlog obtenerBlog(Integer id) {
        if(entradaBlogRepository.obtenerBlog(id) == null)
            throw new NotFoundException("Blog con entrada " + id + " no existe.");
        return entradaBlogRepository.obtenerBlog(id);
    }

    @Override
    public List<EntradaBlog> obtenerTodos() {
        return entradaBlogRepository.obtenerTodos();
    }
}
