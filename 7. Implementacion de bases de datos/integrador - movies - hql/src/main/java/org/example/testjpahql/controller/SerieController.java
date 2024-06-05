package org.example.testjpahql.controller;


import lombok.RequiredArgsConstructor;
import org.example.testjpahql.service.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final ISerieService serieService;

    @GetMapping("/seasons/{num}")
    @ResponseBody
    public ResponseEntity<?> getSeriesWithSeasons(@PathVariable Integer num){
        return ResponseEntity.ok(serieService.getSerieWithSeasons(num));
    }

}
