package com.example.demo.service;

import com.example.demo.model.dto.BookDTO;
import com.example.demo.model.entity.Book;
import com.example.demo.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl{

    private final IBookRepository bookRepository;

    public BookDTO save(BookDTO bookDto) {
        Book book = convertToEntity(bookDto);
        bookRepository.save(book);
        return convertToDTO(book);
    }

    public List<BookDTO> findAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return convertToDTOs(books);
    }

    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return convertToDTOs(books);
    }

    public List<BookDTO> findByTitleContaining(String keyword) {
        List<Book> books = bookRepository.findByTitleContaining(keyword);
        return convertToDTOs(books);
    }

    public List<BookDTO> findByPublisher(String publisher) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        return convertToDTOs(books);
    }

    public List<BookDTO> findByPublicationYearBefore(Year year) {
        List<Book> books = bookRepository.findByPublicationYearBefore(year);
        return convertToDTOs(books);
    }

    public List<BookDTO> findTop5ByOrderByPageCountDesc() {
        List<Book> books = bookRepository.findTop5ByOrderByPageCountDesc();
        return convertToDTOs(books);
    }

    private List<BookDTO> convertToDTOs(List<Book> books) {
        return books.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPageCount(),
                book.getPublisher(),
                book.getPublicationYear()
        );
    }

    public Book convertToEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setPageCount(dto.getPageCount());
        book.setPublisher(dto.getPublisher());
        book.setPublicationYear(dto.getPublicationYear());
        return book;
    }
}
