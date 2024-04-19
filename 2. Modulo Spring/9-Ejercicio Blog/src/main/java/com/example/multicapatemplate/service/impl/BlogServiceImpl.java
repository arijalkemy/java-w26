package com.example.multicapatemplate.service.impl;

import com.example.multicapatemplate.dto.BlogEntryDto;
import com.example.multicapatemplate.exceptions.BadRequestException;
import com.example.multicapatemplate.exceptions.NotFoundException;
import com.example.multicapatemplate.model.BlogEntry;
import com.example.multicapatemplate.repository.impl.BlogRepositoryImpl;
import com.example.multicapatemplate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogRepositoryImpl blogRepository;

    @Override
    public List<BlogEntryDto> getAll() {

        List<BlogEntry> blogs = blogRepository.getAll();
        if( blogs.isEmpty()){
            throw new NotFoundException("No blogs found");
        }

        return blogs.stream().map( x -> new BlogEntryDto(x) ).collect( Collectors.toList());

    }

    @Override
    public BlogEntryDto findById(Integer id) {

        BlogEntry blog = this.blogRepository.findById(id);
        if(blog == null){
            throw new NotFoundException("Invalid blog id");
        }

        return new BlogEntryDto( blog );
    }

    @Override
    public int save(BlogEntryDto blogEntryDto) {
        BlogEntry blog = new BlogEntry( blogEntryDto.getId(), blogEntryDto.getTitle(), blogEntryDto.getAuthorName(), blogEntryDto.getDate() );
        boolean isSaved = blogRepository.save( blog );

        if( !isSaved){
            throw new BadRequestException("Blog already exists");
        }
        return blog.getId();
    }
}
