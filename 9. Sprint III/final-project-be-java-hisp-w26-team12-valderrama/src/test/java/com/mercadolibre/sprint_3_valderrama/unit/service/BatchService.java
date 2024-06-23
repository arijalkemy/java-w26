package com.mercadolibre.sprint_3_valderrama.unit.service;

import com.mercadolibre.sprint_3_valderrama.repository.IBatchStockRepository;
import com.mercadolibre.sprint_3_valderrama.repository.IUserRepository;
import com.mercadolibre.sprint_3_valderrama.repository.IWarehouseRepository;
import com.mercadolibre.sprint_3_valderrama.service.IBatchService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BatchService {

    @InjectMocks
    IBatchService batchService;

    @Mock
    IBatchStockRepository batchRepository;
    @Mock
    IUserRepository userRepository;
    @Mock
    IWarehouseRepository warehouseRepository;

}
