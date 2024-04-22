package com.example.blog.repository;

import com.example.blog.dto.BlogDTO;
import com.example.blog.exceptions.BlogIdAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository{
    private final Map<Integer, BlogDTO> blogMap = new HashMap<>();
    //private int idCounter = 1;

    public boolean entryExist(Integer id){
        return blogMap.containsKey(id);
    }
    @Override
    public void saveBlog(BlogDTO blogDTO) {
        blogMap.put(blogDTO.getId(), blogDTO);
    }

    @Override
    public String findBlog(Integer id){
        if(blogMap.containsKey(id)){
            BlogDTO blogDTO = blogMap.get(id);
            return  "ID: " + blogDTO.getId() + "\n" +
                    "Título: " + blogDTO.getTitle() + "\n" +
                    "Autor: " + blogDTO.getAuthor() + "\n" +
                    "Fecha: " + blogDTO.getDate();
        }
        return "No existe el blog solicitado";
    }

    @Override
    public Map<Integer, BlogDTO> getAll() {
        return blogMap;
    }
}
