package org.example.blog.service.imp;

import org.example.blog.dto.BlogRequestDTO;
import org.example.blog.dto.BlogResponseDTO;
import org.example.blog.exceptions.blog.BlogAlreadyExistException;
import org.example.blog.exceptions.blog.BlogNotFoundExcpetion;
import org.example.blog.repository.IBlogRepository;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements IBlogService {
    @Autowired
    IBlogRepository blogRepositoryImp;

    @Override
    public int addBlog(BlogRequestDTO blog) {
        if(blogRepositoryImp.blogExist(blog)){
            throw new BlogAlreadyExistException("Ya existe un blog con ese id");
        }
        return blogRepositoryImp.saveBlog(blog);
    }

    @Override
    public BlogResponseDTO getBlog(int id) {
        if(!blogRepositoryImp.blogExist(id)){
            throw new BlogNotFoundExcpetion("El blog no existe");
        }
        return new BlogResponseDTO(
                blogRepositoryImp.getBlogs().stream()
                        .filter(x -> x.getId() == id).findFirst().orElse(null)
        );

    }

    @Override
    public List<BlogResponseDTO> getAllBlog() {
        return blogRepositoryImp.getBlogs().stream().map(
                x -> new BlogResponseDTO(x)
        ).toList();
    }
}
