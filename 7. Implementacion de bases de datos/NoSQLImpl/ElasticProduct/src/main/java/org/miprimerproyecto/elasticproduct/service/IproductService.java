package org.miprimerproyecto.elasticproduct.service;

import org.miprimerproyecto.elasticproduct.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IproductService {
    List<Product> findAll();
    String save(Product product);
}
