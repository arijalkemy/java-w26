package api;
import java.util.List;
import java.util.Map;

import data.BillRepository;
import data.CustomerRepository;
import data.ProductRepository;
import models.Bill;
import models.Customer;
import models.Item;
import models.Product;

public class APISuperMarket  implements API {

    private static APISuperMarket api;

    public static APISuperMarket getInstance()
    {
        if (api == null) {
            api = new APISuperMarket();
        }

        return api;
    }

    @Override
    public int createBill(String dni, List<Product> items) {
        CustomerRepository repository = CustomerRepository.getInstance();

        Customer customerFind = repository.search(dni);
        if (customerFind == null) {
            return -1;
        }
        BillRepository repository2 = BillRepository.getInstance();
        Bill billNew = new Bill(Bill.getId(), customerFind, items);
        billNew.calculateTotalPurchase();

        repository2.add(billNew);

        return billNew.getIdBill();
    }

    @Override
    public boolean createCustomer(String dni, String nombre, String apellido) {
        CustomerRepository repository =  CustomerRepository.getInstance();

        boolean response = repository.createCustomer(dni, nombre, apellido);

        return response;
    }

    @Override
    public Bill getBill(int id) {
        return BillRepository.getInstance().get(id);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = CustomerRepository.getInstance().getAll();
        return customers;
    }

    @Override
    public  Map<String, Product> getItems() {
        return ProductRepository.getInstance().getAll();
    }
    
}
