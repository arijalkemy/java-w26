package meli.bootcamp.star_wars.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import java.util.List;
import meli.bootcamp.star_wars.domain.EntradaBlog;
import meli.bootcamp.star_wars.dto.EntradaBlogDto;
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
    if (obtenerEntradaPorId(entradaBlogDto.getId()) != null) {
      return null;
    }

    EntradaBlog entradaNueva = new EntradaBlog(
        entradaBlogDto.getId(),
        entradaBlogDto.getAutor(),
        entradaBlogDto.getTitulo(),
        LocalDateTime.now()
    );

    blogRepository.crearEntradaBlog(entradaNueva);

    return null;
  }

  @Override
  public EntradaBlogDto obtenerEntradaPorId(Long id) {
    EntradaBlog entrada = blogRepository.obtenerEntradaPorId(id);
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
