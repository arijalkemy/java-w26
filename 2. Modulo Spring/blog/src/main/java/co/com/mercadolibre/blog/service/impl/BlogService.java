package co.com.mercadolibre.blog.service.impl;

import co.com.mercadolibre.blog.dto.BlogDto;
import co.com.mercadolibre.blog.entity.BlogEntry;
import co.com.mercadolibre.blog.exception.BlogEntryAlreadyExistsException;
import co.com.mercadolibre.blog.exception.NotFoundException;
import co.com.mercadolibre.blog.repository.IBlogRepository;
import co.com.mercadolibre.blog.service.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Integer save(BlogDto blogDto) {
        if (this.repository.existBlogEntry(blogDto.getId()).get()) {
            throw new BlogEntryAlreadyExistsException("El blog con ese id ya existe");
        }
        this.repository.save(this.mapper.convertValue(blogDto, BlogEntry.class));
        return 0;
    }

    @Override
    public BlogDto getById(Integer id) {
        Optional<BlogEntry> blogEntry = this.repository.findBlogEntryById(id);
        if (!blogEntry.isPresent()) {
            throw new NotFoundException("El blog no existe");
        }
        return this.mapper.convertValue(blogEntry.get(), BlogDto.class);
    }

    @Override
    public List<BlogDto> getAll() {
        return this.repository.findAllBlogEntries().stream()
                .map(blogEntry -> this.mapper.convertValue(blogEntry, BlogDto.class))
                .collect(Collectors.toList());
    }
}
