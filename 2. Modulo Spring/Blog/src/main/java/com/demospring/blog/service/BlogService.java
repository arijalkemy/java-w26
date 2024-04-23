package com.demospring.blog.service;

import com.demospring.blog.exceptions.RepeticionIdException;
import com.demospring.blog.model.EntradaBlog;
import com.demospring.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void addEntrada(EntradaBlog entrada) {
        if(blogRepository.getEntrada(entrada.getId()) != null){
            throw new RepeticionIdException("El id: " + entrada.getId() + " ya existe. La entrada no sera añadida ya que el id debe ser unico.");
        }
        blogRepository.addEntrada(entrada);
    }

    @Override
    public EntradaBlog getEntrada(int id) {
        return blogRepository.getEntrada(id);
    }

    @Override
    public List<EntradaBlog> getEntradas() {
        return blogRepository.getEntradas();
    }
}
