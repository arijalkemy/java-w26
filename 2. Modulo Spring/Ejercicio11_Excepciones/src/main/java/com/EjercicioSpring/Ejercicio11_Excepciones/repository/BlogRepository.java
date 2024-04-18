package com.EjercicioSpring.Ejercicio11_Excepciones.repository;

import com.EjercicioSpring.Ejercicio11_Excepciones.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio11_Excepciones.entity.Blog;
import com.EjercicioSpring.Ejercicio11_Excepciones.service.interfaces.IBlogService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    private BaseDeDatos baseDeDatos = BaseDeDatos.getBaseDeDatos();

    @Override
    public boolean crearBlog(Blog blog) {
        if (baseDeDatos.getBlogs().containsKey(blog.getId())) {
            return false;
        }
        baseDeDatos.agregarBlog(blog);
        return true;
    }

    @Override
    public Blog obtenerBlogPorID(Long id) {
        if (baseDeDatos.getBlogs().containsKey(id)) {
            return baseDeDatos.getBlogs().get(id);
        }
        return null;
    }

    @Override
    public List<Blog> obtenerBlogs() {
        return new ArrayList<>(baseDeDatos.getBlogs().values());
    }
}
