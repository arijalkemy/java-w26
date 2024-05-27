package org.example.movieshql.services.serviceImpl;

import org.example.movieshql.DTO.SerieResponseDto;
import org.example.movieshql.repository.ISerieRepository;
import org.example.movieshql.services.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {

    @Autowired
    ISerieRepository serieRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SerieResponseDto> listSeriesWithMoreThanNTemp(Integer temp_number) {
        return serieRepository.listSeriesWithMoreThanNTemp(temp_number)
                .stream()
                .map(series -> modelMapper.map(series, SerieResponseDto.class))
                .toList();
    }

    @Override
    public List<SerieResponseDto> listAllEpisodesByActorName(String name_actor) {
        return serieRepository.listAllEpisodesByActorName(name_actor).stream()
                .map(series -> modelMapper.map(series, SerieResponseDto.class))
                .toList();
    }
}
