package com.example.demo.service;

import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public List<BookResponse> getBooksByAuthor(String author) {
        return bookRepository.findBookByAuthor(author).stream().map(
                this::mapBookToBookResponse
        ).toList();
    }

    @Override
    public List<BookResponse> getBooksByWordInTitle(String word) {
        return bookRepository.findBookByTitleContaining(word).stream().map(
                this::mapBookToBookResponse
        ).toList();
    }

    @Override
    public List<BookResponse> getBooksWithMorePagesInOrder() {
        Sort sort = Sort.by(Sort.Direction.DESC, "pages");

        return bookRepository.findAll(sort).stream().map(
                this::mapBookToBookResponse
        ).toList().subList(0,5);
    }

    @Override
    public List<BookResponse> getBooksDateBefore(Date date) {
        return bookRepository.findBookByPublishedDateBefore(date).stream().map(
                this::mapBookToBookResponse
        ).toList();
    }

    @Override
    public List<BookResponse> getBooksByPublisher(String publisher) {
        return bookRepository.findBookByPublisher(publisher).stream().map(
                this::mapBookToBookResponse
        ).toList();
    }

    private BookResponse mapBookToBookResponse( Book b ){
        return BookResponse.builder()
                .author(b.getAuthor())
                .pages(b.getPages())
                .title(b.getTitle())
                .publishedDate(b.getPublishedDate())
                .publisher(b.getPublisher())
                .build();
    }
}


