package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {

    private List<Buyer> buyers;
    private final FileDataBaseUtil<Buyer> fileDataBaseBuyer;

    public BuyerRepositoryImpl(FileDataBaseUtil<Buyer> fileDataBaseUtil) {
        this.fileDataBaseBuyer = fileDataBaseUtil;
        this.buyers = fileDataBaseUtil.readFromJsonFile("buyer.json");
    }

    @Override
    public List<Buyer> findAll() {
      return buyers;
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
    public boolean remove(Buyer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
