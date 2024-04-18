package org.mercadolibre.multicapatemplate.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.dto.BlogEntryRequestDTO;
import org.mercadolibre.multicapatemplate.dto.BlogEntryResponseDTO;
import org.mercadolibre.multicapatemplate.entity.BlogEntry;
import org.mercadolibre.multicapatemplate.repository.BlogEntryRepositoryImpl;
import org.mercadolibre.multicapatemplate.service.IBlogEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogEntryServiceImpl implements IBlogEntryService {

    final BlogEntryRepositoryImpl blogEntryRepository;

    public BlogEntryServiceImpl(BlogEntryRepositoryImpl blogEntryRepository) {
        this.blogEntryRepository = blogEntryRepository;
    }

    public int saveBlogEntry(BlogEntryRequestDTO blogEntryRequestDTO) {
        return blogEntryRepository.save(
                new ObjectMapper().convertValue(blogEntryRequestDTO, BlogEntry.class)
        );
    }

    public List<BlogEntryResponseDTO> findAll(){
        return blogEntryRepository.getAll().stream().map( x -> new ObjectMapper().convertValue(x, BlogEntryResponseDTO.class))
                .toList();
    }

}
