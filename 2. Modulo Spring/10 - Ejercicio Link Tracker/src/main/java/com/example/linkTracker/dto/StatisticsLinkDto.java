package com.example.linkTracker.dto;

import com.example.linkTracker.model.Link;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatisticsLinkDto {
    String id;
    int accessCounter;

    public StatisticsLinkDto(Link link ) {
        this.id = link.getId();
        this.accessCounter = link.getAccessCounter();
    }
}
