package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.ShoppingCartProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IShoppingCartProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.IFrescosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FrescosServiceImpl implements IFrescosService {
    @Autowired
    IShoppingCartProductRepository shoppingCartProductRepository;

    /**
     * US-2-ISSUE-6 View products from cart service
     *
     * En esta implementacion hacemos llamado al query method dentro del repo
     * El cual nos trae una lista de Productos de una order
     * posteriormente lo mapeamos a un Set para que traiga productos unicos
     * y no una lista con todos los valores repetidos
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Set<ProductDto> getProductsFromShoppingCart(Integer id) {
        List<ShoppingCartProduct> productsFromShoppingCart =
                shoppingCartProductRepository.findDistinctByShoppingCardId(id);
        List<ProductDto> productsFromCartMapped =
                productsFromShoppingCart
                        .stream()
                        .map(e-> new ProductDto(e.getProduct().getName(),e.getProduct().getPrice())).toList();
        return new HashSet<>(productsFromCartMapped);
    }
}
