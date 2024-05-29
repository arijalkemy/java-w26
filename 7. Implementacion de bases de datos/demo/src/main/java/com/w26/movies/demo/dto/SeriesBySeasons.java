package com.w26.movies.demo.dto;

import java.io.Serializable;


import com.w26.movies.demo.entity.Serie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeriesBySeasons implements Serializable {
    private Serie serie;
    private Integer count;
}
