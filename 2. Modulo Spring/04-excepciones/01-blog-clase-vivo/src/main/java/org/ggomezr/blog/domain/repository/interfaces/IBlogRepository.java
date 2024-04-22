package org.ggomezr.blog.domain.repository.interfaces;

import org.ggomezr.blog.domain.entity.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    Integer saveBlogEntry(BlogEntry blogEntry);

    List<BlogEntry> getAllBlogEntries();
}
