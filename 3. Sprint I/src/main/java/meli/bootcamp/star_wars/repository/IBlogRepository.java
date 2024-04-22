package meli.bootcamp.star_wars.repository;

import java.util.List;
import meli.bootcamp.star_wars.domain.EntradaBlog;

public interface IBlogRepository {
  EntradaBlog crearEntradaBlog(EntradaBlog entradaBlogDto);

  EntradaBlog obtenerEntradaPorId(Long id);

  List<EntradaBlog> obtenerEntradas();
}
