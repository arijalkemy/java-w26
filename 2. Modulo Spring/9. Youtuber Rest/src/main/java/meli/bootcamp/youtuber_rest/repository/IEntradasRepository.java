package meli.bootcamp.youtuber_rest.repository;

import meli.bootcamp.youtuber_rest.entity.EntradaBlog;

public interface IEntradasRepository {
  EntradaBlog guardar(EntradaBlog entradaBlog);
  long getSiguienteId();
}
