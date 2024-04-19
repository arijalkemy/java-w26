package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogEntryRequest;
import com.mercadolibre.blog.dto.ResponseMessage;
import com.mercadolibre.blog.entity.BlogEntry;
import com.mercadolibre.blog.service.imp.BlogEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "blog")
@RequiredArgsConstructor
public class BlogEntryController {
    private final BlogEntryService blogEntryService;
    @GetMapping
    public ResponseEntity<List<BlogEntry>> getAllBlogEntries() {
        return ResponseEntity.ok(blogEntryService.findAll());
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<BlogEntry> getBlogEntryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(blogEntryService.findById(id));
    }
    @PostMapping
    public ResponseEntity<ResponseMessage> createEntry(@RequestBody BlogEntryRequest blogEntry) {
        int id = blogEntryService.saveEntry(blogEntry);
        return ResponseEntity.ok(new ResponseMessage("Se creó la entrada con id: " + id));
    }


}
