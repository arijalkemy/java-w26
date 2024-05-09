package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;

@Repository
public class SellerRepositoryImpl implements SellerRepository {

    private List<Seller> sellers;
    private final FileDataBaseUtil<Seller> sellerManager;

    public SellerRepositoryImpl(FileDataBaseUtil<Seller> sellerManager) {
        this.sellerManager = sellerManager;
        this.sellers = this.sellerManager.readFromJsonFile("seller.json", Seller.class);
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Seller> findById(int id) {
        return sellers
                .stream()
                .filter(seller -> seller.getId() == id)
                .findFirst();

    }

    @Override
    public void add(Seller entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(Seller entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
