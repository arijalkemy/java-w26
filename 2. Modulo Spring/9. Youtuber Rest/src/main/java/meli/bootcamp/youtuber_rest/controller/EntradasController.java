package meli.bootcamp.youtuber_rest.controller;

import meli.bootcamp.youtuber_rest.dto.EntradasBlogDto;
import meli.bootcamp.youtuber_rest.dto.ResponseEntradaDto;
import meli.bootcamp.youtuber_rest.service.IEntradasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class EntradasController {

  IEntradasService entradasService;

  EntradasController(IEntradasService entradasService) {
    this.entradasService = entradasService;
  }

  @PostMapping()
  public ResponseEntity<?> guardar(@RequestBody EntradasBlogDto entradasBlogDto) {
    ResponseEntradaDto responseEntradaDto = entradasService.guardar(entradasBlogDto);
    return ResponseEntity.ok().body(responseEntradaDto);
  }


}
