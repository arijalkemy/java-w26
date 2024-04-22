package com.javabootcamp.blog.repository;

import com.javabootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository {
    Map<Integer, EntradaBlog> entryBlogList = new HashMap<>();

    public void setEntryBlogList(Map<Integer, EntradaBlog> entryBlogList) {
        this.entryBlogList = entryBlogList;
    }

    public Map<Integer, EntradaBlog> getEntryBlogList() {
        return entryBlogList;
    }

    public void addEntryBlog(EntradaBlog entradaBlog) {
        entryBlogList.put(entradaBlog.getId(), entradaBlog);
    }

    public void deleteEntryBlog(int id) {
        entryBlogList.remove(id);
    }

    public void updateEntryBlog(EntradaBlog entradaBlog) {
        entryBlogList.put(entradaBlog.getId(), entradaBlog);
    }

    public EntradaBlog getEntryBlogById(int id) {
        return entryBlogList.get(id);
    }

    public boolean findById(int id) {
        if(entryBlogList.get(id) != null) {
            return true;
        }
        return false;
    }
}
