package org.miprimerproyecto.elasticproduct.service.imp;

import org.miprimerproyecto.elasticproduct.entity.Product;
import org.miprimerproyecto.elasticproduct.repository.productRepository;
import org.miprimerproyecto.elasticproduct.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements IproductService {

    @Autowired
    private productRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public String save(Product product) {
        try {
            productRepository.save(product);
            return "Product saved successfully";
        } catch (Exception e) {
            return "Error saving product: " + e.getMessage();
        }
    }
}
