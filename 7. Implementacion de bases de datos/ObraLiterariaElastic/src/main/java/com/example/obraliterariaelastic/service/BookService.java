package com.example.obraliterariaelastic.service;

import com.example.obraliterariaelastic.dto.BookDto;
import com.example.obraliterariaelastic.model.Book;
import com.example.obraliterariaelastic.repository.IBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public BookDto create(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(book -> modelMapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findAllByAuthor(String author) {
        return bookRepository.findAllByAuthor(author)
                .stream().map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findAllByNameContains(String name) {
        return bookRepository.findAllByNameContains(name)
                .stream().map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findTopBy5PagesOrderByPagesDesc() {
        bookRepository.findTop5ByOrderByPagesDesc().forEach(System.out::println);
        return bookRepository.findTop5ByOrderByPagesDesc()
                .stream().map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findAllByYearBefore(int year) {
        return bookRepository.findAllByYearBefore(year)
                .stream().map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findAllByEditorialIs(String editorial) {
        return bookRepository.findAllByEditorialIs(editorial)
                .stream().map(book -> modelMapper.map(book, BookDto.class))
                .toList();
    }
}
