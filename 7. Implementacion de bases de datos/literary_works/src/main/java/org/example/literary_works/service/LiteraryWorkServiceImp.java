package org.example.literary_works.service;

import org.example.literary_works.dtos.LiteraryWorkDto;
import org.example.literary_works.dtos.LiteraryWorkResDto;
import org.example.literary_works.models.LiteraryWork;
import org.example.literary_works.repository.ILiteraryWorkRepository;
import org.example.literary_works.service.interfaces.ILiteraryWorkService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkServiceImp implements ILiteraryWorkService {
    private final ILiteraryWorkRepository repository;

    public LiteraryWorkServiceImp(ILiteraryWorkRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LiteraryWorkResDto> findAll() {
        List<LiteraryWork> literaryWorkList = repository.findAll();
        return mapData(literaryWorkList);
    }

    @Override
    public List<LiteraryWorkResDto> findByAuthor(String author) {
        List<LiteraryWork> literaryWorkList = repository.findByAuthorIgnoreCase(author);
        return mapData(literaryWorkList);
    }

    @Override
    public List<LiteraryWorkResDto> findByTitle(String title) {
        List<LiteraryWork> literaryWorkList = repository.findLiteraryWorkByTitleContainingIgnoreCase(title);
        return mapData(literaryWorkList);
    }

    @Override
    public List<LiteraryWorkResDto> getTopFive() {
        List<LiteraryWork> literaryWorkList = repository.findTop5ByOrderByPagesQuantityDesc();
        return mapData(literaryWorkList);
    }

    @Override
    public List<LiteraryWorkResDto> findBeforeYear(Integer year) {
        List<LiteraryWork> literaryWorkList = repository.findLiteraryWorkByYearFirstPublicationBefore(year);
        return mapData(literaryWorkList);
    }

    @Override
    public List<LiteraryWorkResDto> findByPublisher(String publisher) {
        List<LiteraryWork> literaryWorkList = repository.findByPublisherContainingIgnoreCase(publisher);
        return mapData(literaryWorkList);
    }

    private List<LiteraryWorkResDto> mapData(List<LiteraryWork> dataToMap) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dataToMap, new TypeToken<List<LiteraryWorkResDto>>(){}.getType());
    }

    @Override
    public LiteraryWorkResDto create(LiteraryWorkDto literaryWorkDto) {
        ModelMapper mapper = new ModelMapper();
        LiteraryWork literaryWork = mapper.map(literaryWorkDto, LiteraryWork.class);
        LiteraryWork createdLiteraryWork = repository.save(literaryWork);
        return mapper.map(createdLiteraryWork, LiteraryWorkResDto.class);
    }
}
