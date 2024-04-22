package meli.bootcamp.star_wars.repository.impl;

import java.util.List;
import meli.bootcamp.star_wars.domain.EntradaBlog;
import meli.bootcamp.star_wars.repository.IBlogRepository;
import meli.bootcamp.star_wars.utils.EntradasDeBlogDefault;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
  List<EntradaBlog> entradas;

  public BlogRepositoryImpl(EntradasDeBlogDefault entradasDeBlogDefault) {
    this.entradas = entradasDeBlogDefault.entradas;
  }

  @Override
  public EntradaBlog crearEntradaBlog(EntradaBlog entradaBlog) {
    entradas.add(entradaBlog);
    return entradaBlog;
  }

  @Override
  public EntradaBlog obtenerEntradaPorId(Long id) {
    return entradas.stream()
        .filter(entrada -> entrada.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<EntradaBlog> obtenerEntradas() {
    return entradas;
  }
}
