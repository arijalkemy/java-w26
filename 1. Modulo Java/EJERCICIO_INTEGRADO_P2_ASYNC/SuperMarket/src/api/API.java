package api;
import java.util.List;
import java.util.Map;

import models.Bill;
import models.Customer;
import models.Product;

public interface API {
    
    public int createBill(String dni, List<Product> items);
    public Bill getBill(int id);

    public Map<String, Product> getItems();

    public boolean createCustomer(String dni, String nombre, String apellido);
    public List<Customer> getCustomers();

}
