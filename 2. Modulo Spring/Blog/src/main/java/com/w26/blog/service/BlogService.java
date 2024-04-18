package com.w26.blog.service;

import com.w26.blog.dto.BlogRequest;
import com.w26.blog.dto.BlogResponse;
import com.w26.blog.entity.Blog;
import com.w26.blog.exception.CreationBlogException;
import com.w26.blog.exception.GetBlogException;
import com.w26.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BlogService implements  IBlogService {

    final BlogRepository blogRepository;
    @Override
    public BlogResponse createBlog(BlogRequest newBlog) {

        for (Blog blog: blogRepository.getRepository()) {
            if (blog.getId() == newBlog.getId())
            {
                throw new CreationBlogException("El id " + newBlog.getId() + " ya existe!!!");
            }
        }

        Blog blog = new Blog(newBlog.getId(), newBlog.getTitle(), newBlog.getAuthorName(), LocalDate.now());
        blogRepository.add(blog);

        BlogResponse response = new BlogResponse("Blog creado exitosamente!", blog);
        return response;
    }

    @Override
    public Blog getBlog(int id) {

        Blog blogFounded = null;

        for (Blog blog: blogRepository.getRepository()) {
            if (blog.getId() == id)
            {
                blogFounded = blog;
                break;
            }
        }

        if (blogFounded == null)
        {
            throw new GetBlogException("El blog con el id "+ id + " no fue encontrado!!!");
        }

        return blogFounded;
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.getRepository();
    }
}
