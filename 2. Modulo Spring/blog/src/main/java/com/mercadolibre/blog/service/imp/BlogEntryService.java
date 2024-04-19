package com.mercadolibre.blog.service.imp;

import com.mercadolibre.blog.dto.BlogEntryRequest;
import com.mercadolibre.blog.entity.BlogEntry;
import com.mercadolibre.blog.exception.custom.CreationException;
import com.mercadolibre.blog.repository.BlogEntryRepository;
import com.mercadolibre.blog.service.IBlogEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogEntryService implements IBlogEntryService {
    private final BlogEntryRepository blogEntryRepository;
    @Override
    public Integer saveEntry(BlogEntryRequest inputEntry) {
        if (blogEntryRepository.existsById(inputEntry.getId())) {
            throw new CreationException("La entrada con id " + inputEntry.getId() + " ya existe!!");
        }
        BlogEntry newEntry = new BlogEntry(
                inputEntry.getId(),
                inputEntry.getTitle(),
                inputEntry.getAuthorName(),
                LocalDateTime.now()
        );
        blogEntryRepository.save(newEntry);
        return inputEntry.getId();
    }

    @Override
    public List<BlogEntry> findAll() {
        return blogEntryRepository.findAll();
    }

    @Override
    public BlogEntry findById(Integer id) {
        return blogEntryRepository.findById(id);
    }
}
