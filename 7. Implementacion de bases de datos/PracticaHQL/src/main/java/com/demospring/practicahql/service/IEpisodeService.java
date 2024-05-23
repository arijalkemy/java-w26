package com.demospring.practicahql.service;

import java.util.List;

public interface IEpisodeService {
    List<String> findEpisodesByActorName(String firstName, String lastName);
}
