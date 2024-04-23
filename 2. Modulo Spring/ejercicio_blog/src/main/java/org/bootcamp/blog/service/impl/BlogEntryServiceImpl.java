package org.bootcamp.blog.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.blog.dto.BlogEntryDTO;
import org.bootcamp.blog.exception.ExistObjectException;
import org.bootcamp.blog.model.BlogEntry;
import org.bootcamp.blog.repository.BlogEntryRepository;
import org.bootcamp.blog.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogEntryServiceImpl implements BlogEntryService {

    @Autowired
    private BlogEntryRepository blogEntryRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public BlogEntryDTO save(BlogEntryDTO blogEntryDTO) {
        if(blogEntryRepository.validator(blogEntryDTO.getId()))
            throw new ExistObjectException("Ya existe la entrada del blog.");

        return objectMapper.convertValue(
                blogEntryRepository.save(objectMapper.convertValue(blogEntryDTO, BlogEntry.class))
                , BlogEntryDTO.class);
    }

    @Override
    public List<BlogEntryDTO> getAll() {
        return blogEntryRepository.findAll().stream()
                .map(blogEntry -> objectMapper.convertValue(blogEntry, BlogEntryDTO.class))
                .toList();
    }

    @Override
    public BlogEntryDTO getById(Integer id) {
        return objectMapper.convertValue(blogEntryRepository.findById(id), BlogEntryDTO.class);
    }
}
