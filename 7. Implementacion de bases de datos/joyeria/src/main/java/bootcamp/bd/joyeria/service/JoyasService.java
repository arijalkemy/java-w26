package bootcamp.bd.joyeria.service;

import java.util.List;

import bootcamp.bd.joyeria.model.Joya;

public interface JoyasService {
    List<Joya> searchAll();
    Long create(Joya joya);
    void delete(Long id);
    Joya update(Joya joya, Long id);
}
