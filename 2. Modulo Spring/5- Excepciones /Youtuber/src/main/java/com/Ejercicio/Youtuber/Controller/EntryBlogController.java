package com.Ejercicio.Youtuber.Controller;

import com.Ejercicio.Youtuber.Entity.EntryBlog;
import com.Ejercicio.Youtuber.Service.IEntryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryBlogController {
    @Autowired
    IEntryBlogService iEntryBlogService;

    @PostMapping(path = "saveEntryBlog")
    public Integer saveEntryBlog(@RequestBody EntryBlog entryBlog){
        return iEntryBlogService.saveEntryBlog(entryBlog);
    }
}
