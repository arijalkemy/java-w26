package com.Ejercicio.Youtuber.Repository;

import com.Ejercicio.Youtuber.Entity.EntryBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EntryBlogRepositoryImpl implements IEntryBlogRepository {
    Map<Integer, EntryBlog> entryBlogMap = new HashMap<>();

    @Override

    public boolean exist(Integer id) {
        return entryBlogMap.containsKey(id);
    }

    @Override
    public Integer saveEntryBlog(EntryBlog entryBlog) {
        entryBlogMap.put(entryBlog.getId(), entryBlog);
        return entryBlog.getId();
    }
}
