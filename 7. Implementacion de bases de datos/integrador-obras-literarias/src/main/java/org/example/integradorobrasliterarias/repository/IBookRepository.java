package org.example.integradorobrasliterarias.repository;

import org.example.integradorobrasliterarias.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends ElasticsearchRepository <Book, String> {

    List<Book> findAllByAuthorName(String name);
    List<Book> findAllByEditorial(String editorial);
    List<Book> findAllByNameContaining(String keyword);
    List<Book> findTop5ByOrderByPagesDesc();
    List<Book> findAllByPublicationYearBefore(Integer year);
}
