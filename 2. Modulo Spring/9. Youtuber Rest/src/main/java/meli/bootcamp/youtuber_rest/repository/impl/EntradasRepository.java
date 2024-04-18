package meli.bootcamp.youtuber_rest.repository.impl;

import java.util.ArrayList;
import java.util.List;
import meli.bootcamp.youtuber_rest.entity.EntradaBlog;
import meli.bootcamp.youtuber_rest.repository.IEntradasRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class EntradasRepository implements IEntradasRepository {
  List<EntradaBlog> entradas;

  EntradasRepository() {
    this.entradas = new ArrayList<>();
  }

  @Override
  public EntradaBlog guardar(EntradaBlog entradaBlog) {
    entradas.add(entradaBlog);
    return entradaBlog;
  }

  public long getSiguienteId() {
    return CollectionUtils.isEmpty(this.entradas)
        ? 1
        : this.entradas.size() + 1;

  }
}
