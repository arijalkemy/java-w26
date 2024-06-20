package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.request.SetStockLevelDTO;
import com.mercadolibre.sprint_3_team_12.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/")

public class StockController {

    @Autowired
    private IStockService stockService;

    /**
     * Sets the minimum stock level for a product.
     *
     * @param productId ID of the product.
     * @param stockLevel DTO containing the minimum stock level.
     * @return ResponseEntity with a confirmation message.
     */
    @PostMapping("/products/{productId}/stock-level")
    public ResponseEntity<?> setMinimumStockLevel(
            @PathVariable Long productId,
            @RequestBody SetStockLevelDTO stockLevel) {
        stockService.setMinimumStockLevel(productId, stockLevel.getMinimumStock());
        return ResponseEntity.ok("Minimum stock level set successfully.");
    }

    /**
     * Gets notifications for products with stock below the minimum level.
     *
     * @return ResponseEntity containing the list of notifications.
     */
    @GetMapping("/notifications/low-stock")
    public ResponseEntity<?> getLowStockNotifications() {
        return ResponseEntity.ok(stockService.getLowStockNotifications());
    }

}
