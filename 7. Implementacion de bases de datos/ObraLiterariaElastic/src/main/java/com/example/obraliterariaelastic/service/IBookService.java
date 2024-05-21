package com.example.obraliterariaelastic.service;

import com.example.obraliterariaelastic.dto.BookDto;

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
