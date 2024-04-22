package meli.bootcamp.star_wars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import java.util.List;
import meli.bootcamp.star_wars.domain.EntradaBlog;
import meli.bootcamp.star_wars.dto.EntradaBlogDto;
import meli.bootcamp.star_wars.exception.DuplicatedIdException;
import meli.bootcamp.star_wars.exception.NotFoundException;
import meli.bootcamp.star_wars.repository.IBlogRepository;
import meli.bootcamp.star_wars.service.IBlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {

  IBlogRepository blogRepository;

  public BlogServiceImpl(IBlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  @Override
  public EntradaBlogDto crearEntradaBlog(EntradaBlogDto entradaBlogDto) {
    if (blogRepository.obtenerEntradaPorId(entradaBlogDto.getId()) != null) {
      throw new DuplicatedIdException("Ya existe una entidad con id " + entradaBlogDto.getId());
    }

    EntradaBlog entradaNueva = new EntradaBlog(
        entradaBlogDto.getId(),
        entradaBlogDto.getAutor(),
        entradaBlogDto.getTitulo(),
        LocalDateTime.now()
    );

    blogRepository.crearEntradaBlog(entradaNueva);

    return crearEntradaDto(entradaNueva);
  }

  @Override
  public EntradaBlogDto obtenerEntradaPorId(Long id) {
    EntradaBlog entrada = blogRepository.obtenerEntradaPorId(id);

    if(entrada == null) {
      throw new NotFoundException("No hay entrada con id " + id);
    }

    return crearEntradaDto(entrada);
  }

  @Override
  public List<EntradaBlogDto> obtenerEntradas() {
    List<EntradaBlog> entradasBlog = blogRepository.obtenerEntradas();
    return crearEntradasDto(entradasBlog);
  }

  private List<EntradaBlogDto> crearEntradasDto(List<EntradaBlog> entradas) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    return entradas.stream().map(e -> mapper.convertValue(e, EntradaBlogDto.class)).toList();
  }

  private EntradaBlogDto crearEntradaDto(EntradaBlog entrada) {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    return mapper.convertValue(entrada, EntradaBlogDto.class);
  }
}
