package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {
  FindService findService;

  public FindController(FindService findService) {
    this.findService = findService;
  }

  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
    return findService.find(query);
  }
}
