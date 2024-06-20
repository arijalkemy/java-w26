package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.response.NotificationDTO;
import java.util.List;

public interface IStockService {
    void setMinimumStockLevel(Long productId, Integer minimumStock);
    List<NotificationDTO> getLowStockNotifications();
}
