package org.bootcamp.implementacionnosql_producto.service;

import org.bootcamp.implementacionnosql_producto.dto.ProductDTO;
import org.bootcamp.implementacionnosql_producto.dto.ResponseProductDTO;

public interface IProductService {
    ResponseProductDTO createProduct(ProductDTO product);
    ResponseProductDTO updateProduct(String id, ProductDTO product);
}
