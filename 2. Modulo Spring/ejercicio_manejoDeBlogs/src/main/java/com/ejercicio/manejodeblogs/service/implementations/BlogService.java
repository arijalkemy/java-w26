package com.ejercicio.manejodeblogs.service.implementations;

import com.ejercicio.manejodeblogs.DTO.BlogEntryRequestDTO;
import com.ejercicio.manejodeblogs.entity.BlogEntry;
import com.ejercicio.manejodeblogs.exception.AlreadyExistException;
import com.ejercicio.manejodeblogs.exception.NotFoundException;
import com.ejercicio.manejodeblogs.repository.implementations.BlogRepository;
import com.ejercicio.manejodeblogs.repository.interfaces.IBlogRepository;
import com.ejercicio.manejodeblogs.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public String addBlog(BlogEntry blogEntry) {
        BlogEntry result = blogRepository.add(blogEntry);
        if(result == null) throw new AlreadyExistException("Ya existe un Blog con id: " + blogEntry.getId());
        return "Blog creado corectamente con Id: " + result.getId();
    }

    @Override
    public BlogEntry getBlogById(int id) {
        BlogEntry result = blogRepository.getById(id);
        if(result == null) throw new NotFoundException("No se encontró un blog con el Id indicado.");
        return result;
    }

    @Override
    public List<BlogEntry> getAllBlogs() {
        return blogRepository.getAll();
    }
}
