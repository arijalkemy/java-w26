package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import interfaces.ICrudRepository;
import models.Bill;

public class BillRepository implements ICrudRepository<Bill, List<Bill>> {


    public static BillRepository repository;
    private List<Bill> bills;

    private BillRepository()
    {
        this.bills = new ArrayList<>();
    }

    public static BillRepository getInstance()
    {
        if (repository == null) {
            repository = new BillRepository();
        }

        return repository;
    }

    @Override
    public Bill remove(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void add(Bill newEntity) {
        bills.add(newEntity);
    }

    @Override
    public void add(Bill... newEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Bill get(int id) {
        // TODO Auto-generated method stub

        Optional<Bill> billF = this.bills.stream().filter(billI -> billI.getIdBill() == id).findFirst();

        if (billF.isPresent()) {
            return billF.get();
        }

        return null;
    }

    @Override
    public List<Bill> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
