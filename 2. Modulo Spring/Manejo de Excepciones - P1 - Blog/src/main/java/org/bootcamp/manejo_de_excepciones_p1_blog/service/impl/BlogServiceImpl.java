package org.bootcamp.manejo_de_excepciones_p1_blog.service.impl;

import org.bootcamp.manejo_de_excepciones_p1_blog.dto.BlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.RequestBlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.ResponseBlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;
import org.bootcamp.manejo_de_excepciones_p1_blog.exception.ExistingResourceException;
import org.bootcamp.manejo_de_excepciones_p1_blog.exception.NonExistentResourceException;
import org.bootcamp.manejo_de_excepciones_p1_blog.repository.BlogRepository;
import org.bootcamp.manejo_de_excepciones_p1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public ResponseBlogDTO addBlog(RequestBlogDTO blogDTO) {
        Blog isExist = blogRepository.getBlogById(blogDTO.getId());
        if (isExist != null) throw new ExistingResourceException("El recurso ya existe");

        ResponseBlogDTO responseBlogDTO = new ResponseBlogDTO();
        Blog blog = blogDTO.getBlog();
        Integer id = blogDTO.getId();

        responseBlogDTO.setId(blogRepository.createNewBlog(id, blog));
        responseBlogDTO.setMessage("Blog creado con exito");

        return responseBlogDTO;
    }

    @Override
    public List<BlogDTO> getBlogs() {
        List<BlogDTO> blogs = new ArrayList<>();

        for (Map.Entry<Integer, Blog> b : blogRepository.getAllBlogs().entrySet()) {
            blogs.add(new BlogDTO(b.getKey(), b.getValue()));
        }

        return blogs;
    }

    @Override
    public BlogDTO getBlog(Integer id) {
        Blog blog = blogRepository.getBlogById(id);
        if (blog == null) throw new NonExistentResourceException("El blog no existe");

        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(id);
        blogDTO.setBlog(blog);

        return blogDTO;
    }
}
