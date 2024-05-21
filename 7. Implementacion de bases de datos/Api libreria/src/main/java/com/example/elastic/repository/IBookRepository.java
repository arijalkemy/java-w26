package com.example.elastic.repository;

import com.example.elastic.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findAll();

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByNameContains(String name);

    List<Book> findTop5ByOrderByPagesDesc();

    List<Book> findAllByYearBefore(int year);

    List<Book> findAllByEditorialIs(String editorial);
}
