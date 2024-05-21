package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,String> {

    List<Book> findBookByAuthor(String author );

    List<Book> findBookByTitleContaining( String word);

    // Esto se podia hacer asi -> List<Book> findTop10ByOrderPagesDesc();
    List<Book> findAll( Sort sort);

    List<Book> findBookByPublishedDateBefore( Date date);

    List<Book> findBookByPublisher( String publisher);
}
