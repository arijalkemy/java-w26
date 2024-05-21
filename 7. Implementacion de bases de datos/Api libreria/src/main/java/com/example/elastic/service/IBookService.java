package com.example.elastic.service;

import com.example.elastic.dto.BookDto;

import java.util.List;

public interface IBookService {

    BookDto create(BookDto bookDto);

    List<BookDto> findAll();

    List<BookDto> findAllByAuthor(String author);

    List<BookDto> findAllByNameContains(String name);

    List<BookDto> findTopBy5PagesOrderByPagesDesc();

    List<BookDto> findAllByYearBefore(int year);

    List<BookDto> findAllByEditorialIs(String editorial);
}
