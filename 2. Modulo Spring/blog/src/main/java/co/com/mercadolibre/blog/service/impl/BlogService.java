package co.com.mercadolibre.blog.service.impl;

import co.com.mercadolibre.blog.dto.BlogDto;
import co.com.mercadolibre.blog.entity.BlogEntry;
import co.com.mercadolibre.blog.exception.BlogEntryAlreadyExistsException;
import co.com.mercadolibre.blog.exception.NotFoundException;
import co.com.mercadolibre.blog.repository.IBlogRepository;
import co.com.mercadolibre.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public Integer save(BlogDto blogDto) {
        if (this.repository.existBlogEntry(blogDto.getId()).get()) {
            throw new BlogEntryAlreadyExistsException("El blog con ese id ya existe");
        }
        this.repository.save(this.mapToBlogEntry(blogDto));
        return 0;
    }

    @Override
    public BlogDto getById(Integer id) {
        Optional<BlogEntry> blogEntry = this.repository.findBlogEntryById(id);
        if (!blogEntry.isPresent()) {
            throw new NotFoundException("El blog no existe");
        }
        return this.mapToDto(blogEntry.get());
    }

    @Override
    public List<BlogDto> getAll() {
        return this.repository.findAllBlogEntries().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private BlogEntry mapToBlogEntry(BlogDto blogDto) {
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setId(blogDto.getId());
        blogEntry.setTitle(blogDto.getTitle());
        blogEntry.setAuthorName(blogDto.getAuthorName());
        blogEntry.setPublicationDate(blogDto.getPublicationDate());
        return blogEntry;
    }

    private BlogDto mapToDto(BlogEntry blogEntry) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blogEntry.getId());
        blogDto.setTitle(blogEntry.getTitle());
        blogDto.setAuthorName(blogEntry.getAuthorName());
        blogDto.setPublicationDate(blogEntry.getPublicationDate());
        return blogDto;
    }
}
