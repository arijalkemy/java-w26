package com.example.HQL.service;

import com.example.HQL.dto.response.EpisodeResponseDto;
import com.example.HQL.dto.response.SeriesResponseDto;

import java.util.List;

public interface ISerieService {
    List<SeriesResponseDto> searchAllWithMoreSeasonsThan(Integer minSeasons);
    List<EpisodeResponseDto> searchAllEpisodesWithActor(String actorName);
}
