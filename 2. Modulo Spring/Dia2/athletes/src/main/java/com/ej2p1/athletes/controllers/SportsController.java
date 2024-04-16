package com.ej2p1.athletes.controllers;

import com.ej2p1.athletes.model.Sport;
import com.ej2p1.athletes.services.ISportsViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {

    @Autowired
    private ISportsViewer SportsViewerService;

    @GetMapping("/findSports")
    public List<Sport> findAllSports() {
        return SportsViewerService.findAllSports();
    }

    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<String> findSportLevelByName(@PathVariable String sportName) {
        String sportLevel = SportsViewerService.findSportLevelByName(sportName);
        if (sportLevel != null) {
            return ResponseEntity.ok(sportLevel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
