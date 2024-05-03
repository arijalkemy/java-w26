package org.tests.starwars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tests.starwars.dto.CharacterDTO;
import org.tests.starwars.service.FindService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FindController {
  @Autowired
  private FindService findService;

  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
    return findService.find(query);
  }
}
