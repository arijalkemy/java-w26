package meli.bootcamp.youtuber_rest.service;

import meli.bootcamp.youtuber_rest.dto.EntradasBlogDto;
import meli.bootcamp.youtuber_rest.dto.ResponseEntradaDto;

public interface IEntradasService {
  ResponseEntradaDto guardar(EntradasBlogDto entradasBlogDto);
}
