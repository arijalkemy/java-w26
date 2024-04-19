package com.example.multicapatemplate.service;

import com.example.multicapatemplate.dto.BlogEntryDto;
import com.example.multicapatemplate.model.BlogEntry;

import java.util.List;

public interface IBlogService {

    List<BlogEntryDto> getAll();

    BlogEntryDto findById(Integer id);

    int save(BlogEntryDto blogEntryDto);
}
