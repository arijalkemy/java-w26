package com.mercadolibre.sprint3_individual_perez.unit.service;

import com.mercadolibre.sprint3_individual_perez.repository.IBatchStockRepository;
import com.mercadolibre.sprint3_individual_perez.repository.IUserRepository;
import com.mercadolibre.sprint3_individual_perez.repository.IWarehouseRepository;
import com.mercadolibre.sprint3_individual_perez.service.IBatchService;
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
