package co.com.mercadolibre.blog.repository.impl;

import co.com.mercadolibre.blog.entity.BlogEntry;
import co.com.mercadolibre.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<BlogEntry> blogList = new ArrayList<>();

    @Override
    public Optional<Integer> save(BlogEntry blogEntry) {
        blogList.add(blogEntry);
        return Optional.of(blogEntry.getId());
    }

    @Override
    public Optional<Boolean> existBlogEntry(Integer id) {
        boolean exists = blogList.stream()
                .anyMatch(blog -> blog.getId().equals(id));
        return Optional.of(exists);
    }

    @Override
    public Optional<BlogEntry> findBlogEntryById(Integer id) {
        Optional<BlogEntry> blogEntry = blogList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
        return blogEntry;
    }

    @Override
    public List<BlogEntry> findAllBlogEntries() {
        return this.blogList;
    }

}
