package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;
    private final FileDataBaseUtil<Product> productManager;

    public ProductRepositoryImpl(FileDataBaseUtil<Product> productFileManager) {
        this.productManager = productFileManager;
        this.products = this.productManager.readFromJsonFile("product.json");
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Product entity) {

        boolean existed = remove(entity);

        if(!existed) {
            entity.setId(products.size() + 1);
        }

        products.add(entity);
        productManager.saveData(products, "product.json");
    }

    @Override
    public boolean remove(Product entity) {

        boolean exists = this.products
                .stream()
                .anyMatch(p -> p.getId() == entity.getId());

        if (exists) {
            this.products.remove(entity);
            productManager.saveData(products, "product.json");
        }

        return exists;
    }
}
