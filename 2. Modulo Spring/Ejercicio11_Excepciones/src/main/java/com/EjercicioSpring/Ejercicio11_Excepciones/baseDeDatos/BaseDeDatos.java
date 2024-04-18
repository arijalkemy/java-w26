package com.EjercicioSpring.Ejercicio11_Excepciones.baseDeDatos;

import com.EjercicioSpring.Ejercicio11_Excepciones.entity.Blog;

import java.util.HashMap;
import java.util.Map;

public class BaseDeDatos {

    private static BaseDeDatos baseDeDatos;
    private Map<Long, Blog> blogs;

    public void agregarBlog(Blog blog){
        blogs.put(blog.getId(), blog);
    }

    public static void setBaseDeDatos(BaseDeDatos baseDeDatos) {
        BaseDeDatos.baseDeDatos = baseDeDatos;
    }

    public Map<Long, Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Map<Long, Blog> blogs) {
        this.blogs = blogs;
    }

    private BaseDeDatos() {
        blogs = new HashMap<>();
    }

    public static BaseDeDatos getBaseDeDatos() {
        if (baseDeDatos == null) {
            baseDeDatos = new BaseDeDatos();
        }
        return baseDeDatos;
    }
}
