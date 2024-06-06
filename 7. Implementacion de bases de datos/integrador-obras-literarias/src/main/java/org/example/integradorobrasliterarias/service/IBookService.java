package org.example.integradorobrasliterarias.service;


import org.example.integradorobrasliterarias.entity.Book;
import org.example.integradorobrasliterarias.entity.dto.BookRequestDTO;
import org.example.integradorobrasliterarias.entity.dto.BookResponseDTO;

import java.util.List;

public interface IBookService {

    void saveBook(BookRequestDTO book);
    List<BookResponseDTO> getAllBooks();
    List<BookResponseDTO> findAllByAuthorName(String name);
    List<BookResponseDTO> findAllByEditorial(String editorial);
    List<BookResponseDTO> findAllByKeyword(String keyword);
    List<BookResponseDTO> findAllTopByPages();
    List<BookResponseDTO> findAllByPublicationYearBefore(Integer year);
}
