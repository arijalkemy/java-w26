package com.mercadolibre.final_project_java_hisp_w26_t6.services.batch;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchStockListResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Batch;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.BatchMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IBatchesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.BatchSortType;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.DateSortType;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.EnumChecker;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class BatchServiceImpl implements IBatchService {

    private final IBatchesRepository batchesRepository;

    public BatchServiceImpl(IBatchesRepository batchesRepository) {
        this.batchesRepository = batchesRepository;
    }

    @Override
    @Transactional
    public BatchStockListResponseDto getBatchesInDueDate(int cantDays, String storageType,
                                                         String dateSortType) {

        List<Batch> batchesDueDate = batchesRepository
                .findAllByDueDateBetweenOrderByDueDate(LocalDate.now().atStartOfDay(),
                        LocalDate.now().atStartOfDay().plusDays(cantDays));

        EnumChecker.isValidEnum(StorageType.class, storageType, "Invalid storage type: " + storageType);

        if(storageType != null){
            batchesDueDate = batchesDueDate.stream()
                    .filter(b -> b.getProduct()
                            .getStorageType().equals(StorageType.valueOf(storageType.toUpperCase())))
                    .toList();
        }

        EnumChecker.isValidEnum(DateSortType.class, dateSortType, "Invalid date order type: " + dateSortType);

        List<Batch> orderedBatches = orderBatchesList(batchesDueDate, dateSortType);

        return BatchMapper.createBatchStockListResponseDto(orderedBatches);
    }

    private List<Batch> orderBatchesList(List<Batch> batches, String orderType) {

        EnumChecker.isValidEnum(DateSortType.class, orderType, "Invalid date order type: " + orderType);

        if(orderType == null){
            orderType = DateSortType.date_asc.name();
        }

        DateSortType orderEnum = BatchSortType.valueOf(DateSortType.class, orderType);

        Comparator<Batch> batchComparator = Comparator.comparing(Batch::getDueDate);
        if(orderEnum != DateSortType.date_asc){
            batchComparator = batchComparator.reversed();
        }

        return batches
                .stream()
                .sorted(batchComparator)
                .toList();
    }
}
