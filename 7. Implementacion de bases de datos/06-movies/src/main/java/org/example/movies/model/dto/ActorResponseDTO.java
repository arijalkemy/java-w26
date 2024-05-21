package org.example.movies.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponseDTO {

    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Movie favoriteMovie;
}
