package org.example._09blog.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example._09blog.DTO.GetBlogResponseDTO;
import org.example._09blog.DTO.NewBlogRequestDTO;
import org.example._09blog.DTO.NewBlogResponseDTO;
import org.example._09blog.Exceptions.AlreadyExistsException;
import org.example._09blog.Exceptions.NotFoundException;
import org.example._09blog.Model.Blog;
import org.example._09blog.Repository.IRepository;
import org.example._09blog.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IRepository blogRepository;

    @Override
    public GetBlogResponseDTO retrieveBlog(int id) {
        Blog blog = blogRepository.find(id);
        if (blog == null) {
            throw new NotFoundException("Blog with id " + id + " not found");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(blog, GetBlogResponseDTO.class);
        }
    }

    @Override
    public NewBlogResponseDTO createBlog(NewBlogRequestDTO newBlogRequestDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Blog blogToCreate = mapper.convertValue(newBlogRequestDTO, Blog.class);
        Blog savedBlog = blogRepository.save(blogToCreate);
        if (savedBlog == null) {
            throw new AlreadyExistsException("Blog with id " + newBlogRequestDTO.getId() + " already exists");
        } else {
            return new NewBlogResponseDTO(newBlogRequestDTO.getId());
        }
    }

    @Override
    public List<GetBlogResponseDTO> retrieveAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        List<GetBlogResponseDTO> blogResponseDTOList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        blogs.forEach(b -> blogResponseDTOList.add(mapper.convertValue(b, GetBlogResponseDTO.class)));
        return blogResponseDTOList;
    }
}
