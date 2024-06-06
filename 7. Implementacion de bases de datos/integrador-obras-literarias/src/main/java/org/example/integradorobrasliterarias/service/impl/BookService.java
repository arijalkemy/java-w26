package org.example.integradorobrasliterarias.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorobrasliterarias.entity.Book;
import org.example.integradorobrasliterarias.entity.dto.BookRequestDTO;
import org.example.integradorobrasliterarias.entity.dto.BookResponseDTO;
import org.example.integradorobrasliterarias.repository.IBookRepository;
import org.example.integradorobrasliterarias.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final IBookRepository bookRepository;
    private final ObjectMapper objectMapper;

    private Book mapToEntity(BookRequestDTO bookRequestDTO){
        return objectMapper.convertValue(bookRequestDTO, Book.class);
    }

    private BookResponseDTO mapToDTO(Book book){
        return objectMapper.convertValue(book, BookResponseDTO.class);
    }

    @Override
    public void saveBook(BookRequestDTO book) {
        bookRepository.save(mapToEntity(book));
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        Iterable<Book> bookIterable = bookRepository.findAll();
        List<Book> bookList = StreamSupport.stream(bookIterable.spliterator(), false).toList();
        return bookList.stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<BookResponseDTO> findAllByAuthorName(String name) {
        return bookRepository.findAllByAuthorName(name).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<BookResponseDTO> findAllByKeyword(String keyword) {
        return bookRepository.findAllByNameContaining(keyword).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<BookResponseDTO> findAllTopByPages() {
        return bookRepository.findTop5ByOrderByPagesDesc().stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<BookResponseDTO> findAllByPublicationYearBefore(Integer year) {
        return bookRepository.findAllByPublicationYearBefore(year).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<BookResponseDTO> findAllByEditorial(String editorial) {
        return bookRepository.findAllByEditorial(editorial).stream().map(this::mapToDTO).toList();
    }
}
