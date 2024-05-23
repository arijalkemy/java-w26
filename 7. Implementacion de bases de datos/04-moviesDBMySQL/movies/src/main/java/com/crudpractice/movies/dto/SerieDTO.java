package com.crudpractice.movies.dto;



import com.crudpractice.movies.entity.Genre;
import com.crudpractice.movies.entity.Season;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private Integer id;
    private String title;
    private Date releaseDate;
    private Date endDate;
    @JsonIgnore
    private Genre genre;
    @JsonIgnore
    private List<Season> seasons;
}
