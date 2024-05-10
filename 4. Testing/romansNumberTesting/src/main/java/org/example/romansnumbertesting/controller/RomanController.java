package org.example.romansnumbertesting.controller;

import org.example.romansnumbertesting.dto.RomanDto;
import org.example.romansnumbertesting.service.IRomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romans")
public class RomanController {
    private final IRomanService romanService;

    public RomanController(@Autowired IRomanService romanService) {
        this.romanService = romanService;
    }

    @GetMapping("/encode/{number}")
    public ResponseEntity<RomanDto> decodeRomanNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(romanService.encodeRomanNumber(number), HttpStatus.OK);
    }
}
