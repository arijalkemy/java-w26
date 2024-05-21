package com.example.demo.service;

import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;

import java.util.Date;
import java.util.List;

public interface IBookService {

    String addBook(Book book);
    List<BookResponse> getBooksByAuthor(String author );
    List<BookResponse> getBooksByWordInTitle(String word );
    List<BookResponse> getBooksWithMorePagesInOrder();
    List<BookResponse> getBooksDateBefore( Date date );
    List<BookResponse> getBooksByPublisher( String publisher );
}
