package data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import interfaces.ICrudRepository;
import interfaces.ILoadable;

//

import models.Product;

public class ProductRepository implements ILoadable, ICrudRepository<Product, Map<String, Product>> {
    
    private Map<String, Product> products;
    private static ProductRepository repository;

    private ProductRepository(){
        this.products = new HashMap<>();
    } 

    public static ProductRepository getInstance()
    {
        if (repository == null) {
            repository = new ProductRepository();
            repository.load();
        }

        return repository;
    }
 
    @Override
    public void load() {
        Product baseProduct = Product.of(300, UUID.randomUUID().toString(), "Manzanas", 1500);
        products.put(baseProduct.getName(), baseProduct);
    }

    @Override
    public Product remove(int id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void add(Product newEntity) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void add(Product... newEntity) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Product get(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Map<String, Product> getAll() {
        return products;
    }

    
}
