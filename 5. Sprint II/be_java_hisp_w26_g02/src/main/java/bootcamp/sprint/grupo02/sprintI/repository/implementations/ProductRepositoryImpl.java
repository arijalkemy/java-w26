package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>(
                List.of(new Product(1, "Termo", "Tipo 1", "Stanley", "Verde", "Muy caro para lo que es"),
                        new Product(2, "Macbook ", "Pro", "Air", "Gris", "Buena compu")));
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
        products.add(entity);
    }

    @Override
    public void remove(Product entity) {

    }
}
