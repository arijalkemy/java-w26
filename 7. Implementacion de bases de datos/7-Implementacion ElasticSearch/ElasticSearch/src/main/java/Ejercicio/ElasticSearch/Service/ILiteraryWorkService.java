package Ejercicio.ElasticSearch.Service;

import Ejercicio.ElasticSearch.Dto.LiteraryWorkRequestDto;
import Ejercicio.ElasticSearch.Dto.LiteraryWorkResponseDto;
import java.time.LocalDate;
import java.util.List;

public interface ILiteraryWorkService {
    LiteraryWorkResponseDto createLiteraryWork(LiteraryWorkRequestDto literaryWorkRequestDt);
    List<LiteraryWorkResponseDto> getLiteraryWorkByAutor(String autor);

    List<LiteraryWorkResponseDto> getLiteraryWorkByName(String name);

    List <LiteraryWorkResponseDto> getLiteraryWorkWithMorePages();

    List<LiteraryWorkResponseDto> getLiteraryWorkByPublicationDateLessThan(LocalDate publicationDate);
}
