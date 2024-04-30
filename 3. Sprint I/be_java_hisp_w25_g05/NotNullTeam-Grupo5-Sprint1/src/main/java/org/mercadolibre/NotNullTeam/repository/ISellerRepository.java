package org.mercadolibre.NotNullTeam.repository;

import org.mercadolibre.NotNullTeam.model.Seller;

import java.util.Optional;

public interface ISellerRepository {
    Optional<Seller> findById(Long id);
    void save(Seller seller);
}
