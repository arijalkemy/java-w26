package meli.bootcamp.youtuber_rest.service.impl;

import java.time.LocalDateTime;
import meli.bootcamp.youtuber_rest.dto.EntradasBlogDto;
import meli.bootcamp.youtuber_rest.dto.ResponseEntradaDto;
import meli.bootcamp.youtuber_rest.entity.EntradaBlog;
import meli.bootcamp.youtuber_rest.repository.IEntradasRepository;
import meli.bootcamp.youtuber_rest.service.IEntradasService;
import org.springframework.stereotype.Service;

@Service
public class EntradasServiceImpl implements IEntradasService {

  IEntradasRepository entradasRepository;

  EntradasServiceImpl(IEntradasRepository entradasRepository) {
    this.entradasRepository = entradasRepository;
  }

  @Override
  public ResponseEntradaDto guardar(EntradasBlogDto entradasBlogDto) {
    EntradaBlog entradaBlog = new EntradaBlog();
    entradaBlog.setAutor(entradaBlog.getAutor());
    entradaBlog.setId(entradasRepository.getSiguienteId());
    entradaBlog.setTitulo(entradasBlogDto.getTitulo());
    entradaBlog.setFechaPublicacion(LocalDateTime.now());

    EntradaBlog entradasBlog = entradasRepository.guardar(entradaBlog);

    return new ResponseEntradaDto("Se ha creado con éxito", entradasBlog.getId());
  }
}
