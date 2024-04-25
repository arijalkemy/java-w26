package org.example.ejercicioblog.repository;

import jakarta.websocket.OnClose;
import org.example.ejercicioblog.entity.EntradaBlog;
import org.example.ejercicioblog.exception.ConflictException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BlogRepository implements IBlogRepository{
    List<EntradaBlog> blogs= new ArrayList<>();
    @Override
    public void addBlog(EntradaBlog blog){
        for (EntradaBlog existingBlog : blogs) {
            if (existingBlog.getId() == blog.getId()) {
                throw new ConflictException("El blog con el id " + blog.getId() + " ya existe.");
            }
        }
        blogs.add(blog);
    }

    @Override
    public List<EntradaBlog> findAll(){
        return blogs;
    }
    @Override
    public EntradaBlog findById(int id){
        for (EntradaBlog blog : blogs) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }
}
