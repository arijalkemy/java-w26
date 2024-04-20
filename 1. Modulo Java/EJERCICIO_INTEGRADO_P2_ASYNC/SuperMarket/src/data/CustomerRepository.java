package data;
import java.util.LinkedList;
import java.util.List;

import interfaces.ICrudRepository;
import models.Customer;
import interfaces.ISearch;
public class CustomerRepository implements ICrudRepository<Customer, List<Customer>>, ISearch<Customer, String>{

    private static CustomerRepository repository;

    private List<Customer> customers;
    
    private CustomerRepository(){
        this.customers = new LinkedList<>();
    }

    public static CustomerRepository getInstance(){

        if (repository == null) {
           repository = new CustomerRepository();
        }
        
        return repository;
    }

    public static void updateCustomer(){}

    public boolean createCustomer(String dni, String nombre, String apellido)
    {

        if (this.existCustomer(dni))
           return false;

        Customer customerNew = new Customer(nombre, apellido, dni);
        repository.add(customerNew);

        return true;
    }

    public boolean existCustomer(String dni){
        if (repository.getAll().size() == 0)
            return false;

        for (Customer c : repository.getAll()) {
            if (c.getDni().equals(dni)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(Customer newEntity) {
        this.customers.add(newEntity);
    }

    @Override
    public void add(Customer... newEntity) {
        for (int i = 0; i < newEntity.length; i++) {
            this.customers.add(newEntity[i]);
        }
    }

    @Override
    public Customer get(int id) {
        return this.customers.get(id); 
    }

    @Override
    public List<Customer> getAll() {
        return this.customers;
    }
    
    @Override
    public Customer search(String localizatorEntity) {
        for (Customer customer : customers) {
            if (localizatorEntity.equals(customer.getDni())) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer remove(int id) {
        return this.customers.remove(id);
    }

}
