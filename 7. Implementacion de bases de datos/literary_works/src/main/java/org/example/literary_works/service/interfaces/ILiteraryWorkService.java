package org.example.literary_works.service.interfaces;

import org.example.literary_works.dtos.LiteraryWorkDto;
import org.example.literary_works.dtos.LiteraryWorkResDto;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkResDto> findAll();
    List<LiteraryWorkResDto> findByAuthor(String author);
    List<LiteraryWorkResDto> findByTitle(String title);
    List<LiteraryWorkResDto> getTopFive();
    List<LiteraryWorkResDto> findBeforeYear(Integer year);
    List<LiteraryWorkResDto> findByPublisher(String publisher);
    LiteraryWorkResDto create(LiteraryWorkDto literaryWorkDto);
}
