package co.com.mercadolibre.blog.repository;

import co.com.mercadolibre.blog.entity.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {

    Optional<Integer> save(BlogEntry blogEntry);
    Optional<Boolean> existBlogEntry(Integer id);
    Optional<BlogEntry> findBlogEntryById(Integer id);
    List<BlogEntry> findAllBlogEntries();
}
