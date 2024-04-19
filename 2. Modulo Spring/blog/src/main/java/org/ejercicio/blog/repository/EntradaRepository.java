package org.ejercicio.blog.repository;

import org.ejercicio.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntradaRepository implements IEntradaBlogRepository{

    private Map<Integer, EntradaBlog> entradaBlogs;

    public EntradaRepository() {
        this.entradaBlogs = new HashMap<Integer, EntradaBlog>();
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        return entradaBlogs.values().stream().toList();
    }

    @Override
    public EntradaBlog buscarPorId(int id) {
        return entradaBlogs.get(id);
    }

    @Override
    public void agregarBlog(EntradaBlog entradaBlog) {
        entradaBlogs.put(entradaBlog.getId(), entradaBlog);
    }
}
