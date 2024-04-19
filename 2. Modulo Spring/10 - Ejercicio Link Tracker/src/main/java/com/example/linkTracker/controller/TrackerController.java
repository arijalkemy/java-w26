package com.example.linkTracker.controller;

import com.example.linkTracker.service.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TrackerController {

    @Autowired
    ITrackerService templateService;

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable int id){
        return new ResponseEntity(templateService.findById(id), HttpStatus.OK);
    }
}
