package com.practicaSpring.blog.service;

import com.practicaSpring.blog.dto.BlogEntryDTO;
import com.practicaSpring.blog.exception.DuplicateEntryIdException;
import com.practicaSpring.blog.exception.IdNotFoundException;
import com.practicaSpring.blog.model.BlogEntry;
import com.practicaSpring.blog.repository.IBlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryServiceImpl implements IBlogEntryService{

    @Autowired
    private IBlogEntryRepository blogEntryRepository;

    @Override
    public Long createEntry(BlogEntryDTO blogEntry) {
        Long response = blogEntryRepository.save(blogEntry);
        if(response == null){
            throw new DuplicateEntryIdException("Id: " + blogEntry.getId() + " already exists on the blog.");
        }
        return response;
    }

    @Override
    public BlogEntryDTO getEntryById(Long id) {
        BlogEntry entry = blogEntryRepository.findById(id);
        if(entry == null){
            throw new IdNotFoundException("Id: " + id + " does not exist on the blog.");
        }
        return new BlogEntryDTO(entry.getId(), entry.getTitle(), entry.getAuthor(), entry.getPublishDate());
    }

    @Override
    public List<BlogEntryDTO> getAllEntries() {
        return blogEntryRepository.findAll().stream().map(entry ->
                new BlogEntryDTO(entry.getId(), entry.getTitle(), entry.getAuthor(), entry.getPublishDate())
        ).collect(Collectors.toList());
    }
}
