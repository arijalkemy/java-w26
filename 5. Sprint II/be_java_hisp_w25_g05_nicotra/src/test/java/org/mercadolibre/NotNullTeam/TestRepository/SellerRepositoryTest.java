package org.mercadolibre.NotNullTeam.TestRepository;

import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Profile("test")
public class SellerRepositoryTest implements ISellerRepository {

    List<Seller> sellers;

    public SellerRepositoryTest() {
        this.sellers = new ArrayList<>();

        User sellerUser = User.builder().id(5L).name("userSeller").build();

        Seller seller = Seller.builder().user(sellerUser).followersList(new ArrayList<>()).build();

        save(seller);
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return sellers.stream().filter(
                b -> Objects.equals(b.getUser().getId(), id)
        ).findFirst();
    }

    @Override
    public void save(Seller seller) {
        sellers.add(seller);
    }

    @Override
    public void update(Seller seller) {

    }
}
