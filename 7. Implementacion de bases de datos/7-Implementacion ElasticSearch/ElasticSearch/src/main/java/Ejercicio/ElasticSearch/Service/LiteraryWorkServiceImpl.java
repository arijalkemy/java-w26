package Ejercicio.ElasticSearch.Service;


import Ejercicio.ElasticSearch.Dto.LiteraryWorkRequestDto;
import Ejercicio.ElasticSearch.Dto.LiteraryWorkResponseDto;
import Ejercicio.ElasticSearch.Entity.LiteraryWork;
import Ejercicio.ElasticSearch.Repository.IElasticRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LiteraryWorkServiceImpl implements ILiteraryWorkService {
    IElasticRepository elasticRepository;

    ModelMapper modelMapper;

    public LiteraryWorkServiceImpl(IElasticRepository elasticRepository, ObjectMapper objectMapper) {
        this.elasticRepository = elasticRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public LiteraryWorkResponseDto createLiteraryWork(LiteraryWorkRequestDto literaryWorkRequestDto) {
        LiteraryWork literaryWork = modelMapper.map(literaryWorkRequestDto, LiteraryWork.class);
        elasticRepository.save(literaryWork);
        return modelMapper.map(literaryWork, LiteraryWorkResponseDto.class);
    }

    @Override
    public List<LiteraryWorkResponseDto> getLiteraryWorkByAutor(String autor) {
        List<LiteraryWork> literaryWorks = elasticRepository.findByAuthor(autor);
        return literaryWorks.stream().map(literaryWork -> modelMapper.map(literaryWork, LiteraryWorkResponseDto.class)).toList();

    }

    @Override
    public List<LiteraryWorkResponseDto> getLiteraryWorkByName(String name) {
        List<LiteraryWork> obras = elasticRepository.findByNameLike(name);
        return obras.stream().map(literaryWork -> modelMapper.map(literaryWork, LiteraryWorkResponseDto.class)).toList();
    }

    @Override
    public List<LiteraryWorkResponseDto> getLiteraryWorkWithMorePages() {
        List<LiteraryWorkResponseDto> literaryWorkResponseDtoList = elasticRepository.findAllByPagesOrderByPagesDesc()
                .stream()
                .map(literaryWork -> modelMapper.map(literaryWork, LiteraryWorkResponseDto.class))
                .limit(5)
                .toList();
        return literaryWorkResponseDtoList;
    }

    @Override
    public List<LiteraryWorkResponseDto> getLiteraryWorkByPublicationDateLessThan(LocalDate publicationDate) {
        List<LiteraryWork> obras = elasticRepository.findByPublicationDateLessThanEqual(publicationDate );
        return obras.stream().map(literaryWork -> modelMapper.map(literaryWork, LiteraryWorkResponseDto.class)).toList();
    }


}
