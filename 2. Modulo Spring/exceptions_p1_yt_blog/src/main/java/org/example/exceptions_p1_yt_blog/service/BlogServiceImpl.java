package org.example.exceptions_p1_yt_blog.service;

import org.example.exceptions_p1_yt_blog.dto.BlogDTO;
import org.example.exceptions_p1_yt_blog.entity.Blog;
import org.example.exceptions_p1_yt_blog.exceptions.BadRequestException;
import org.example.exceptions_p1_yt_blog.exceptions.NotFoundException;
import org.example.exceptions_p1_yt_blog.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    BlogRepositoryImpl blogRepository;

    @Override
    public List<BlogDTO> getAll() {

        List<Blog> blogs = blogRepository.getAll();
        if( blogs.isEmpty()){
            throw new NotFoundException("No blogs found");
        }

        return blogs.stream().map(BlogDTO::new).collect( Collectors.toList());

    }

    @Override
    public BlogDTO findById(Integer id) {

        Blog blog = this.blogRepository.findById(id);
        if(blog == null){
            throw new NotFoundException("Invalid blog id");
        }

        return new BlogDTO( blog );
    }

    @Override
    public int save(BlogDTO blogEntryDto) {
        Blog blog = new Blog(
                blogEntryDto.getId(),
                blogEntryDto.getTitle(),
                blogEntryDto.getAuthorName(),
                blogEntryDto.getDate()
        );
        boolean isSaved = blogRepository.save( blog );

        if( !isSaved){
            throw new BadRequestException("Blog already exists");
        }
        return blog.getId();
    }
}
