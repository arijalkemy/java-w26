package com.ej1p1dia4spring.blog.repository;

import com.ej1p1dia4spring.blog.entity.EntradaBlog;
import com.ej1p1dia4spring.blog.exceptions.AlreadyExistsException;
import com.ej1p1dia4spring.blog.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    List<EntradaBlog> entradas = new ArrayList<>();

    @Override
    public void agregarEntradaBlog(EntradaBlog entradaBlog) {
        if(entradas.stream().anyMatch(e -> e.getId() == entradaBlog.getId())){
            throw new AlreadyExistsException("La entrada ya existe en el sistema");
        }
        entradas.add(entradaBlog);
    }

    @Override
    public EntradaBlog obtenerEntradaBlog(int id) {
        Optional<EntradaBlog> entradaEncontrada = entradas.stream().filter(e -> e.getId() == id).findFirst();
        if (entradaEncontrada.isPresent()) {
            return entradaEncontrada.get();
        } else {
            throw new NotFoundException("No se encuentra el id en el sistema");
        }
    }

    @Override
    public List<EntradaBlog> obtenerEntradaBlogs() {
        return entradas;
    }
}
