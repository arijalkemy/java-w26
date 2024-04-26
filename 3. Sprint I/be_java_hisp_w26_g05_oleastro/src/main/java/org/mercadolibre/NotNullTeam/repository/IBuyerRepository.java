package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Buyer;

import java.util.List;
import java.util.Optional;

public interface IBuyerRepository {
    Optional<Buyer> findById(Long id);
    void save(Buyer buyer);
    List<Buyer> findAll();
    boolean existsById(Long id);
    void update(Buyer buyer);
}
