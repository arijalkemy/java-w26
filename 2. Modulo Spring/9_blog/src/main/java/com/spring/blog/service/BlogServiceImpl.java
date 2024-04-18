package com.spring.blog.service;

import com.spring.blog.dto.BlogEntryDTO;
import com.spring.blog.dto.BlogEntryResponseDTO;
import com.spring.blog.entity.BlogEntry;
import com.spring.blog.exception.NotFoundException;
import com.spring.blog.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogsRepository blogsRepository;

    @Override
    public BlogEntryResponseDTO findBlogById(Integer id) {
        BlogEntry foundBlog = this.blogsRepository.getBlogRepository().get(id);
        if (foundBlog == null) {
            throw new NotFoundException("Blog con id " + id + " no encontrado.");
        }
        return this.createBlogResponseDTO(foundBlog);
    }

    @Override
    public List<BlogEntryResponseDTO> findAllBlogs() {
        List<BlogEntryResponseDTO> responseList = new ArrayList<>();
        for (BlogEntry blogEntry : this.blogsRepository.getBlogRepository().values()) {
            responseList.add(this.createBlogResponseDTO(blogEntry));
        }
        return responseList;
    }

    @Override
    public Integer createBlog(BlogEntryDTO blogEntry) {
        BlogEntry newBlog = this.createBlogEntry(blogEntry);
        this.blogsRepository.getBlogRepository().put(newBlog.getId(), newBlog);
        return newBlog.getId();
    }

    private BlogEntryResponseDTO createBlogResponseDTO(BlogEntry blogEntry) {
        return new BlogEntryResponseDTO(
                blogEntry.getId(),
                blogEntry.getTitle(),
                blogEntry.getAutorName(),
                blogEntry.getPublishDate().toString()
        );
    }

    private BlogEntry createBlogEntry(BlogEntryDTO blogEntryDTO) {
        LocalDate localDate = LocalDate.now();
        return new BlogEntry(
                blogEntryDTO.getTitle(),
                blogEntryDTO.getAutorName(),
                localDate
        );
    }
}
