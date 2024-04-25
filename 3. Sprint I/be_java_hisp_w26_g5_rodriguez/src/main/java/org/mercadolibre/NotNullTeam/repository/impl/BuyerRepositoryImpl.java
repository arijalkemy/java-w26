package org.mercadolibre.NotNullTeam.repository.impl;

import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BuyerRepositoryImpl implements IBuyerRepository {

    List<Buyer> buyers = new ArrayList<>();

    @Override
    public Optional<Buyer> findById(Long id) {
        return buyers.stream().filter(
                b -> Objects.equals(b.getUser().getId(), id)
        ).findFirst();
    }

    @Override
    public List<Buyer> findAll() {
        return buyers;
    }

    @Override
    public boolean existsById(Long id) {
        return buyers.stream().anyMatch(
                b -> Objects.equals(b.getUser().getId(), id)
        );
    }

    @Override
    public void save(Buyer buyer) {
        buyers.add(buyer);
    }
}
