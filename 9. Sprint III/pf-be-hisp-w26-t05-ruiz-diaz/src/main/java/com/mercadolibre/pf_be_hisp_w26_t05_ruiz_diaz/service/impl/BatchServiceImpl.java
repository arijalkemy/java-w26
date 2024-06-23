package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.BatchRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchInfoDueDateDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.TypeProduct;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.AlreadyExistsException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper.BatchMapper;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Batch;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Sector;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.util.ProductSectorWarehouseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements IBatchService {
    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;
    private final ISectorRepository sectorRepository;
    private final IWarehouseRepository warehouseRepository;

    private Product findProductById(Integer idProduct) {
        return productRepository.findById(idProduct).orElseThrow(
                () -> new NotFoundException("Product with ID = " + idProduct + " does not exist")
        );
    }

    private Sector findSectorById(Integer idSector) {
        return sectorRepository.findById(idSector).orElseThrow(
                () -> new NotFoundException("Sector with ID = " + idSector + " does not exist")
        );
    }

    private Warehouse findWarehouseById(Integer idWarehouse) {
        return warehouseRepository.findById(idWarehouse).orElseThrow(
                () -> new NotFoundException("Warehouse with ID = " + idWarehouse + " does not exist")
        );
    }

    @Override
    public BatchResponseDTO createInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        BatchRequestDTO batchStock = inboundOrderRequestDTO.getBatchStock();
        Optional<Batch> optionalBatch = batchRepository.findByBatchNumber(batchStock.getBatchNumber());
        if (optionalBatch.isPresent()){
            throw new AlreadyExistsException("Batch with exact same batch_number already exists");
        }
        ProductSectorWarehouseValidator helper = new ProductSectorWarehouseValidator(
                findProductById(batchStock.getIdProduct()),
                findSectorById(inboundOrderRequestDTO.getSection().getSectorId()),
                findWarehouseById(inboundOrderRequestDTO.getSection().getWarehouseCode())
        );
        helper.validate();
        Batch newBatch = BatchMapper.BatchRequestDTOToBatch(
                batchStock,
                helper.getProduct(),
                helper.getSector()
        );
        newBatch.setEntryDate(Instant.now());
        batchRepository.save(newBatch);
        return BatchMapper.BatchToBatchResponseDTO(newBatch);
    }

    @Override
    public BatchResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        BatchRequestDTO batchStock = inboundOrderRequestDTO.getBatchStock();
        String batchNumber = batchStock.getBatchNumber();
        Optional<Batch> optionalBatch = batchRepository.findByBatchNumber(batchNumber);
        if (optionalBatch.isEmpty()) {
            throw new NotFoundException("Batch with batch_number: "+batchNumber+" does not exist.");
        }
        // TODO: Renombrar helper? Renombrar clase?
        ProductSectorWarehouseValidator helper = new ProductSectorWarehouseValidator(
                findProductById(batchStock.getIdProduct()),
                findSectorById(inboundOrderRequestDTO.getSection().getSectorId()),
                findWarehouseById(inboundOrderRequestDTO.getSection().getWarehouseCode())
        );
        helper.validate();
        // TODO: Preguntar si tiene sentido tambien actualizar el producto y el sector del lote
        // Usamos los nuevos que  vienen por parametro o usamos los que estaban?
        Batch actualBatch = optionalBatch.get();
        Batch updatedBatch = BatchMapper.BatchRequestDTOToBatch(
                batchStock,
                helper.getProduct(),    // actualBatch.getProduct(),
                helper.getSector()      // actualBatch.getSector()
        );
        updatedBatch.setId(actualBatch.getId());
        updatedBatch.setEntryDate(actualBatch.getEntryDate());
        batchRepository.save(updatedBatch);
        return BatchMapper.BatchToBatchResponseDTO(updatedBatch);
    }

    @Override
    public BatchStockDTO getBatchStockByProductId(Integer cantDays, Integer managerId, String category, String order) {
        // Calcular las fechas mínima y máxima de vencimiento
        LocalDate maxExpirationDate = LocalDate.now().plusDays(cantDays);
        LocalDate minExpirationDate = LocalDate.now();

        // Obtener los lotes del repositorio con los filtros y el ordenamiento
        List<Batch> batches = getBatches(category, order, managerId, maxExpirationDate, minExpirationDate);

        // Validar que existan lotes en el rango de fechas dado
        validateBatchesExist(batches);

        // Crear y retornar el DTO con la información de los lotes
        return createBatchStockDTO(batches);
    }

    public List<Batch> getBatches(String category, String order, Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate) {
        if(category.equals("All")){
            return getBatchesByOrder(order, managerId, maxExpirationDate, minExpirationDate);
        }

        TypeProduct typeProductEnum = TypeProduct.valueOf(category);
        return getBatchesByTypeAndOrder(typeProductEnum, order, managerId, maxExpirationDate, minExpirationDate);
    }

    public List<Batch> getBatchesByTypeAndOrder(TypeProduct typeProductEnum, String order, Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate) {
        return "date_desc".equals(order)
                ? batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDateDesc(managerId, maxExpirationDate, minExpirationDate, typeProductEnum)
                : batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualAndProduct_TypeOrderByDueDate(managerId, maxExpirationDate, minExpirationDate, typeProductEnum);
    }

    public List<Batch> getBatchesByOrder(String order, Integer managerId, LocalDate maxExpirationDate, LocalDate minExpirationDate) {
        return "date_desc".equals(order)
                ? batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateDesc(managerId, maxExpirationDate, minExpirationDate)
                : batchRepository.findAllBySector_Warehouse_Manager_IdAndDueDateLessThanEqualAndDueDateGreaterThanEqualOrderByDueDateAsc(managerId, maxExpirationDate, minExpirationDate);
    }
    public void validateBatchesExist(List<Batch> batches) {
        if(batches.isEmpty()){
            throw new NotFoundException("No existe ningun lote proximo a vencer dentro del rango de días dado.");
        }
    }

    public BatchStockDTO createBatchStockDTO(List<Batch> batches) {
        return BatchStockDTO.builder()
                .batchStock(batchesToBatchInfoDueDateDto(batches))
                .build();
    }

    public List<BatchInfoDueDateDTO> batchesToBatchInfoDueDateDto(List<Batch> batches) {
        return batches.stream()
                .map(batch -> BatchInfoDueDateDTO.builder()
                        .batchNumber(Integer.parseInt(batch.getBatchNumber()))
                        .productId(batch.getProduct().getId())
                        .productTypeId(batch.getProduct().getId())
                        .dueDate(batch.getDueDate())
                        .currentQuantity(batch.getCurrentQuantity())
                        .build())
                .toList();
    }


}
