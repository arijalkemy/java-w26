package org.mercadolibre.multicapatemplate.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.dto.BlogEntryRequestDTO;
import org.mercadolibre.multicapatemplate.dto.BlogEntryResponseDTO;
import org.mercadolibre.multicapatemplate.entity.BlogEntry;
import org.mercadolibre.multicapatemplate.exception.AlreadyExistsException;
import org.mercadolibre.multicapatemplate.exception.NotFoundException;
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
        if (blogEntryRepository.getById(blogEntryRequestDTO.getId()) == null) {
            BlogEntry blogEntry = blogEntryRepository.save(
                    new ObjectMapper().convertValue(blogEntryRequestDTO, BlogEntry.class)
            );
            return blogEntry.getId();
        } else {
            throw new AlreadyExistsException("El libro con id " + blogEntryRequestDTO.getId() + " ya existe.");
        }
    }

    public BlogEntryResponseDTO findById(int id) {
        BlogEntry blogEntry = blogEntryRepository.getById(id);
        if (blogEntry != null){
            return new ObjectMapper().convertValue(
                    blogEntry,
                    BlogEntryResponseDTO.class
            );
        } else {
            throw new NotFoundException("No se encontro la entrada de blog con id = " + id);
        }
    }

    public List<BlogEntryResponseDTO> findAll(){
        return blogEntryRepository
                .getAll()
                .stream()
                .map( x -> new ObjectMapper().convertValue(x, BlogEntryResponseDTO.class))
                .toList();
    }

}
