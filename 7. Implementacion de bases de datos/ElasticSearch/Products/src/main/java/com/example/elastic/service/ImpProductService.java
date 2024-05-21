package com.example.elastic.service;

import com.example.elastic.domain.Product;
import com.example.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save (Product prod) {

        return productRepository.save(prod);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    //va optional porque puede que devuelva como puede que no
    public Optional<Product> findById (int id) {
        return productRepository.findById(id);

    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Producto eliminado correctamente";
    }

    @Override
    public String editProduct (Product art) {
        productRepository.save(art);
        return "Producto modificado correctamente";
    }
}
