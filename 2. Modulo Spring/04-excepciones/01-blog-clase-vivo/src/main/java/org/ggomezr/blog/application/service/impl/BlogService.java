package org.ggomezr.blog.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.blog.application.service.interfaces.IBlogService;
import org.ggomezr.blog.domain.dto.BlogEntryDTO;
import org.ggomezr.blog.domain.entity.BlogEntry;
import org.ggomezr.blog.domain.exceptions.AlreadyExistingEntryException;
import org.ggomezr.blog.domain.exceptions.EntryNotFound;
import org.ggomezr.blog.domain.repository.impl.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String createBlogEntry(BlogEntryDTO blogEntryDTO) {
        boolean blogEntryExists = blogRepository.getAllBlogEntries().stream()
                .anyMatch(blogEntry -> blogEntry.getId() == blogEntryDTO.getId());

        if(blogEntryExists){
            throw new AlreadyExistingEntryException("Ya existe una entrada de blog con con el mismo ID");
        }else{
            blogRepository.saveBlogEntry(covertToBlogEntry(blogEntryDTO));
            return "La entrada se ha creado correctamente con ID: " + blogEntryDTO.getId();
        }
    }

    @Override
    public List<BlogEntryDTO> getAllBlogEntries() {
        return blogRepository.getAllBlogEntries().stream()
                .map(this::convertToBlogEntryDTO).toList();
    }

    @Override
    public BlogEntryDTO getBlogEntryById(Integer id) {
        Optional<BlogEntryDTO> blogEntryDTOOptional = blogRepository.getAllBlogEntries().stream()
                .filter(blogEntry -> blogEntry.getId() == id)
                .map(this::convertToBlogEntryDTO).findFirst();

        if(blogEntryDTOOptional.isPresent()){
            return blogEntryDTOOptional.get();
        }else{
            throw new EntryNotFound("No se encontro la entrada con el ID: " + id);
        }
    }

    private BlogEntry covertToBlogEntry(BlogEntryDTO blogEntryDTO){
        return objectMapper.convertValue(blogEntryDTO, BlogEntry.class);
    }

    private BlogEntryDTO convertToBlogEntryDTO(BlogEntry blogEntry){
        return objectMapper.convertValue(blogEntry, BlogEntryDTO.class);
    }
}
