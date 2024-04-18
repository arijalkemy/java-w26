package com.EjercicioSpring.Ejercicio11_Excepciones.repository;

import com.EjercicioSpring.Ejercicio11_Excepciones.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio11_Excepciones.entity.Blog;

import java.util.ArrayList;
import java.util.List;

public interface IBlogRepository {
    static final BaseDeDatos baseDeDatos = BaseDeDatos.getBaseDeDatos();

    public boolean crearBlog(Blog blog);

    public Blog obtenerBlogPorID(Long id);

    public List<Blog> obtenerBlogs();
}
