package org.mercadolibre.NotNullTeam.TestRepository;

import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("test")
public class BuyerRepositoryTest implements IBuyerRepository {

    List<Buyer> buyers;

    public BuyerRepositoryTest() {
        this.buyers = new ArrayList<>();

        User buyerUser = User.builder().id(1L).name("userBuyer").build();

        Buyer buyer = Buyer.builder().user(buyerUser).followedList(List.of()).build();

        save(buyer);
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Buyer buyer) {
        buyers.add(buyer);
    }

    @Override
    public List<Buyer> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void update(Buyer buyer) {

    }
}
