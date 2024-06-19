package com.mercadolibre.sprint_3_team_12_malacara.unit.service;

import com.mercadolibre.sprint_3_team_12_malacara.repository.IBatchStockRepository;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IUserRepository;
import com.mercadolibre.sprint_3_team_12_malacara.repository.IWarehouseRepository;
import com.mercadolibre.sprint_3_team_12_malacara.service.IBatchService;
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
