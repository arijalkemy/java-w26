package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogEntryRequest;
import com.mercadolibre.blog.entity.BlogEntry;

import java.util.List;

public interface IBlogEntryService {
    Integer saveEntry(BlogEntryRequest entry);
    List<BlogEntry> findAll();
    BlogEntry findById(Integer id);
}
