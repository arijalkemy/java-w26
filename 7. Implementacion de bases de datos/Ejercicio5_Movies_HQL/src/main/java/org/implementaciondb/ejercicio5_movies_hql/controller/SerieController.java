package org.implementaciondb.ejercicio5_movies_hql.controller;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.SerieDto;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    /**
     * Consigna: 6
     * Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
     *
     * @param numberOfSeasons
     * @return
     */
    @GetMapping("/seasons/number/{number_of_seasons}")
    public ResponseEntity<List<SerieDto>> getSeriesWithMoreSeasonsThan(
            @PathVariable(name = "number_of_seasons") Integer numberOfSeasons
    ) {
        return new ResponseEntity<>(serieService.findSeriesWithMoreSeasonsThan(numberOfSeasons), HttpStatus.OK);
    }

    //

    /**
     * ----------------- Opcional ------------------
     * Listar todas las series de un género específico y con una calificación promedio de episodios mayor a un
     * valor dado
     *
     * @param genreName
     * @param averageRating
     * @return
     */
    @GetMapping("/genre/{genre_name}/average-rating/{average_rating}")
    public ResponseEntity<List<SerieDto>> findSeriesByGenreAndAverageEpisodeRating(
            @PathVariable(name = "genre_name") String genreName,
            @PathVariable(name = "average_rating") Double averageRating
    ) {
        return new ResponseEntity<>(
                serieService.getSeriesByGenreAndAverageEpisodeRating(genreName, averageRating), HttpStatus.OK
        );
    }

}
