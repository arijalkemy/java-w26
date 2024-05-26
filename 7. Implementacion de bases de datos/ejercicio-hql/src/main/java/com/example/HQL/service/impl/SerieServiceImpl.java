package com.example.HQL.service.impl;

import com.example.HQL.dto.response.EpisodeResponseDto;
import com.example.HQL.dto.response.MovieResponseDto;
import com.example.HQL.dto.response.SeriesResponseDto;
import com.example.HQL.model.Episode;
import com.example.HQL.model.Movie;
import com.example.HQL.model.Series;
import com.example.HQL.repository.ISerieRepository;
import com.example.HQL.service.ISerieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements ISerieService {
    private final ISerieRepository serieRepository;
    private final ModelMapper serieMapper;

    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Movie, MovieResponseDto>() {
            @Override
            protected void configure() {
                map().getGenre().setName(source.getGenre().getName());
            }
        });
        this.serieMapper = mapper;
    }

    @Override
    public List<SeriesResponseDto> searchAllWithMoreSeasonsThan(Integer minSeasons) {
        List<Series> series = serieRepository.findAllWithMoreSeasonsThan(minSeasons);
        return series.stream().map(s -> serieMapper.map(s, SeriesResponseDto.class)).toList();
    }

    @Override
    public List<EpisodeResponseDto> searchAllEpisodesWithActor(String actorName) {
        ModelMapper mapper = new ModelMapper();
        List<Episode> episodes = serieRepository.findAllEpisodesWithActor(actorName);
        return episodes.stream().map(episode -> mapper.map(episode, EpisodeResponseDto.class)).toList();
    }
}
