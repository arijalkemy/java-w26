package com.example.libros.repository;

import com.example.libros.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    BlogRepositoryImpl(){
        llenarListaBlogs();
    }


    List<EntradaBlog> listaBlogs = new ArrayList<>();




    private void llenarListaBlogs() {

            listaBlogs.add(new EntradaBlog(1, "Título 1", "Autor 1", "Fecha 1"));
            listaBlogs.add(new EntradaBlog(2, "Título 2", "Autor 2", "Fecha 2"));
            listaBlogs.add(new EntradaBlog(3, "Título 3", "Autor 3", "Fecha 3"));
            listaBlogs.add(new EntradaBlog(4, "Título 4", "Autor 4", "Fecha 4"));
            listaBlogs.add(new EntradaBlog(5, "Título 5", "Autor 5", "Fecha 5"));
            listaBlogs.add(new EntradaBlog(6, "Título 6", "Autor 6", "Fecha 6"));
            listaBlogs.add(new EntradaBlog(7, "Título 7", "Autor 7", "Fecha 7"));
            listaBlogs.add(new EntradaBlog(8, "Título 8", "Autor 8", "Fecha 8"));
            listaBlogs.add(new EntradaBlog(9, "Título 9", "Autor 9", "Fecha 9"));
        }

    @Override
    public List<EntradaBlog> obtenerBlogs(){
            return this.listaBlogs;
    }

    @Override
    public Optional<EntradaBlog> obtenerBlog(int id){
        return this.listaBlogs.stream().filter(blog -> blog.getId() == id).findFirst();
    }

    @Override
    public void crearBlog(EntradaBlog entradaBlog){
        listaBlogs.add(entradaBlog);
    }

}
