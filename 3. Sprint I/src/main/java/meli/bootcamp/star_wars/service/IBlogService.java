package meli.bootcamp.star_wars.service;

import meli.bootcamp.star_wars.dto.EntradaBlogDto;
import java.util.List;

public interface IBlogService {
  EntradaBlogDto crearEntradaBlog(EntradaBlogDto entradaBlogDto);

  EntradaBlogDto obtenerEntradaPorId(Long id);

  List<EntradaBlogDto> obtenerEntradas();
}
