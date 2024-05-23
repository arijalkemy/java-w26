package com.demospring.practicahql.service;

import java.util.List;

public interface ISerieService {
    List<String> findSerieByCantSeasonsOver(int cantSeasons);
}
