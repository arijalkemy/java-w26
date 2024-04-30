package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {

    private List<Buyer> buyers;
    

    public BuyerRepositoryImpl() {
        this.buyers = new ArrayList<>();
        Buyer buyer1 = new Buyer(1, "Comprador", new ArrayList<>());
        Buyer buyer2 = new Buyer(2, "Comprador 2", new ArrayList<>());
        Seller seller1 = new Seller(1, "Un Vendedor", null);
        Seller seller2 = new Seller(2, "Vendedor 2", null);
        buyer1.setFollows(new ArrayList<>(List.of(seller1, seller2)));
        this.buyers.add(buyer1);
        this.buyers.add(buyer2);
    }

    @Override
    public List<Buyer> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Buyer> findById(int id) {
        return buyers.stream()
        .filter(buyer -> buyer.getId() == id)
        .findFirst();
    }

    @Override
    public void add(Buyer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(Buyer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
