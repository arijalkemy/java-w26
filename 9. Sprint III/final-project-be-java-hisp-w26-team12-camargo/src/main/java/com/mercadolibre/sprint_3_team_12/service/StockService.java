package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.response.NotificationDTO;
import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService implements IStockService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void setMinimumStockLevel(Long productId, Integer minimumStockLevel) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ApiException("Product not found", "The product with the given ID was not found.", 404));
        product.setMinimumStock(minimumStockLevel);
        productRepository.save(product);
    }

    @Override
    public List<NotificationDTO> getLowStockNotifications() {
        return productRepository.findAll().stream()
                .filter(product -> product.getCurrentStock() < product.getMinimumStock())
                .map(product -> new NotificationDTO(product.getId(), product.getName(), product.getCurrentStock(), product.getMinimumStock(), "Stock is below minimum level."))
                .collect(Collectors.toList());
    }
}
