package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.ProductStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.BatchDueDateResponseDTO;
import com.mercadolibre.project_java_w26_team13.dtos.BatchesByProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface IBatchService {

    ProductStockDto getProductStockByWarehouse(long productId, String authorizationHeader);

    BatchesByProductDTO searchBatchesByProduct(Long productId, String order, String authorizationHeader) ;

    BatchDueDateResponseDTO getBatchesDueDateByCategory(Integer days,
                                                               String authorizationHeader,
                                                               String categoryFilter,
                                                               String orderFilter);
}
