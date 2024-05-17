package org.example.miniseriemanual.controller;

import jakarta.validation.Valid;
import org.example.miniseriemanual.dto.MiniSerieDto;
import org.example.miniseriemanual.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniserie")
public class MiniSerieController {
    private final IMiniSerieService miniSerieService;

    public MiniSerieController(@Autowired IMiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @PostMapping
    public ResponseEntity<?> postMiniSerie(@RequestBody @Valid MiniSerieDto miniSerie) {
        return new ResponseEntity<>(miniSerieService.save(miniSerie), HttpStatus.OK);
    }
}
