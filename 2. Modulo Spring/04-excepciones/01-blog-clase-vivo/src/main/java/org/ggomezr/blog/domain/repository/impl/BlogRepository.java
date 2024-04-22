package org.ggomezr.blog.domain.repository.impl;

import org.ggomezr.blog.domain.entity.BlogEntry;
import org.ggomezr.blog.domain.repository.interfaces.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    List<BlogEntry> blogEntries = new ArrayList<>();

    @Override
    public Integer saveBlogEntry(BlogEntry blogEntry) {
        blogEntries.add(blogEntry);
        return blogEntry.getId();
    }

    @Override
    public List<BlogEntry> getAllBlogEntries() {
        return blogEntries;
    }
}
