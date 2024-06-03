package com.meli.blog_vivo.service.impl;

import com.meli.blog_vivo.dto.BlogDTO;
import com.meli.blog_vivo.entity.Blog;
import com.meli.blog_vivo.exception.BadRequestException;
import com.meli.blog_vivo.exception.NotFoundException;
import com.meli.blog_vivo.repository.BlogRepository;
import com.meli.blog_vivo.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    public BlogRepository repository = new BlogRepository();

    @Override
    public Integer addBlog(BlogDTO blog) {
        if(repository.findAll().stream().filter(b-> b.getId()==blog.getId()).count()>0){
            throw new BadRequestException("El blog ya existe");
        }
        return repository.createBlog(new Blog(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFechaPublicacion()));
    }

    @Override
    public BlogDTO searchOne(Integer id) {
        Blog blog = repository.findOne(id);
        if(blog == null){
            throw new NotFoundException("El blog no existe");
        }
        BlogDTO result = new BlogDTO(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFechaPublicacion());
        return result;
    }

    @Override
    public List<BlogDTO> searchAll() {
        List<BlogDTO> result = new ArrayList<>();
        for(Blog blog: repository.findAll()){
            result.add(new BlogDTO(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFechaPublicacion()));
        }
        return result;
    }
}
