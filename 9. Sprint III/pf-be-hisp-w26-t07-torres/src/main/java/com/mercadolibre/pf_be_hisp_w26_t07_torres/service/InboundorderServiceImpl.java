package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.others.InboundorderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.stock.StockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.BachMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.mapper.StockMapper;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IInboundorderService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InboundorderServiceImpl implements IInboundorderService {
    private final ISectionRepository sectionRepository;
    private final IBatchRepository batchRepository;
    private final IWarehouseRepository warehouseRepository;
    private final IProductSellerRepository productSellerRepository;
    private final IRepresentativeRepository representativeRepository;
    private final AuthDataUtil authDataUtil;

    public InboundorderServiceImpl(@Autowired ISectionRepository sectionRepository,
                                   @Autowired IBatchRepository batchRepository,
                                   @Autowired IWarehouseRepository warehouseRepository,
                                   @Autowired IProductSellerRepository productSellerRepository,
                                   @Autowired IRepresentativeRepository representativeRepository,
                                   @Autowired AuthDataUtil authDataUtil) {
        this.sectionRepository = sectionRepository;
        this.batchRepository = batchRepository;
        this.warehouseRepository = warehouseRepository;
        this.productSellerRepository = productSellerRepository;
        this.representativeRepository = representativeRepository;
        this.authDataUtil = authDataUtil;
    }

    @Transactional(readOnly = true)
    protected Section getSectionById(Long id) throws NotFoundException {
        return sectionRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.SECTION_NOT_FOUND.getMessage(id))
        );
    }

    @Transactional(readOnly = true)
    protected Warehouse getWarehouseById(Long id) throws NotFoundException {
        return warehouseRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.WAREHOUSE_NOT_FOUND.getMessage(id))
        );
    }

    @Transactional(readOnly = true)
    protected Representative getRepresentativeById(Long id) throws NotFoundException {
        return representativeRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.REPRESENTATIVE_ID_NOT_FOUND.getMessage(id))
        );
    }

    @Transactional(readOnly = true)
    protected ProductSeller getProductSellerById(Long id) throws NotFoundException {
        return productSellerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.PRODUCT_ID_NOT_FOUND.getMessage(id)));
    }

    @Transactional(readOnly = true)
    protected Batch getBatchByNumber(Long batchNumber, Long productSellerId) throws NotFoundException {
        return batchRepository.findBatchByBatchNumberAndProductSellerId(batchNumber, productSellerId).orElse(null);
    }

    /**
     * @param batchStock informacion proveniente del body de la peticion
     * @return batch a actualizar con la nueva informacion homologada del body
     * @throws NotFoundException
     */
    @Transactional(readOnly = true)
    protected Batch updateStockInBatch(BatchStockRequestDTO batchStock) throws NotFoundException {
        Batch batchToUpdate = getBatchByNumber(batchStock.getBatchNumber(), batchStock.getProductId());
        if (batchToUpdate == null) {
            throw new NotFoundException(MessageError.BATCH_NOT_FOUND_NUMBER.getMessage(batchStock.getBatchNumber()));
        }
        batchToUpdate.setCurrentTemperature(BigDecimal.valueOf(batchStock.getCurrentTemperature()));
        batchToUpdate.setMinimumTemperature(BigDecimal.valueOf(batchStock.getMinimumTemperature()));
        batchToUpdate.setInitialQuantity(batchStock.getInitialQuantity());
        batchToUpdate.setCurrentQuantity(batchStock.getCurrentQuantity());
        batchToUpdate.setManufacturingDate(batchStock.getManufacturingDate());
        batchToUpdate.setManufacturingTime(batchStock.getManufacturingTime());
        batchToUpdate.setDueDate(batchStock.getDueDate());
        return batchToUpdate;
    }

    @Transactional(readOnly = true)
    protected Batch createStockInBatch(BatchStockRequestDTO batchStock) throws NotFoundException {
        Batch batchesByProduct = getBatchByNumber(batchStock.getBatchNumber(), batchStock.getProductId());
        if (batchesByProduct == null) {
            return BachMapper.requestDtoToEntity(batchStock);
        }
        throw new NotFoundException(MessageError.BATCH_DUPLICATED_PRODUCT.getMessage(batchStock.getBatchNumber()));
    }

    /**
     * funcion que recorre los distintos lotes e inserta en la base de datos un nuevo registro, siempre y cuando
     * el tipo de producto corresponda al tipo de seccion
     *
     * @param batchStockRequestDTO request proviente del body
     * @param section              seccion a la cual se ligan los productos
     * @param representative       representante que se encuentra login en la aplicacion
     * @param method               (POST, PUT) el cual determina si se crea o actualiza
     * @return lista del stock que se pudo insertar
     * @throws NotFoundException
     */
    @Transactional
    protected List<StockResponseDTO> saveStockInBatch(List<BatchStockRequestDTO> batchStockRequestDTO,
                                                      Section section,
                                                      Representative representative, HttpMethod method) throws NotFoundException {
        List<StockResponseDTO> stockResponse = new ArrayList<>();
        batchStockRequestDTO.forEach((batchStock) -> {
            Long productId = batchStock.getProductId();
            ProductSeller currentProduct = getProductSellerById(productId);

            // Verificar que la seccion y el producto sean del mismo tipo de refrigeracion
            if (!currentProduct.getProduct().getStorageType().getId().equals(section.getStorageType().getId())) {
                throw new NotFoundException(MessageError.SECTION_NOT_ASSOCIATED_WITH_PRODUCT
                        .getMessage(currentProduct.getProduct().getDescription()));
            }

            // Validacion del metodo el cual busca o crea un nuevo batch
            Long batchNumber = batchStock.getBatchNumber();
            Batch batch = (method.equals(HttpMethod.PUT)) ?
                    updateStockInBatch(batchStock) :
                    createStockInBatch(batchStock);

            batch.setRepresentative(representative);
            batch.setProductSeller(currentProduct);

            section.addBatch(batch);
            stockResponse.add(StockMapper.entityToStockResponse(batch));
        });
        sectionRepository.save(section);
        return stockResponse;
    }

    /**
     * funcion hecha para crear o actualizar lotes de productos, los cuales se encuentran asociados
     * a un warehouse
     *
     * @param inboundOrderRequestDTO
     * @param method                 (POST, PUT) el cual determina si se crea o actualiza
     * @return
     * @throws NotFoundException
     */
    @Transactional
    protected BatchStockResponseDTO createOrUpdatedInbounder(InboundorderRequestDTO inboundOrderRequestDTO, HttpMethod method) throws NotFoundException {
        Long representativeId = authDataUtil.getIdSession();
        Representative currentRepresentative = getRepresentativeById(representativeId);

        Long sectionId = inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode();
        Section currentSection = getSectionById(sectionId);
        Long warehouseId = inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode();
        Warehouse currentWarehouse = getWarehouseById(warehouseId);

        if (!currentWarehouse.getSections().contains(currentSection)) {
            throw new NotFoundException(MessageError.SECTION_NOT_ASSOCIATED_WITH_WAREHOUSE.getMessage());
        }

        // Verificar que el representante que se encuentra logeado sea representante del warehouse
        if (!currentWarehouse.getRepresentatives().contains(currentRepresentative)) {
            throw new NotFoundException(MessageError.REPRESENTATIVE_NOT_ASSOCIATED_WITH_WAREHOUSE.getMessage());
        }

        // Valida que la section tenga espacio para el nuevo stock
        if (currentSection.getBatches().size() + inboundOrderRequestDTO.getInboundOrder().getBatchStock().size() > currentSection.getSize()) {
            throw new NotFoundException(MessageError.BATCH_SIZE_EXCCED.getMessage());
        }

        return new BatchStockResponseDTO(
                saveStockInBatch(inboundOrderRequestDTO.getInboundOrder().getBatchStock(),
                        currentSection,
                        currentRepresentative,
                        method));
    }

    @Override
    @Transactional
    public BatchStockResponseDTO saveInboundorder(InboundorderRequestDTO inboundOrderRequestDTO) {
        return createOrUpdatedInbounder(inboundOrderRequestDTO, HttpMethod.POST);
    }

    @Override
    @Transactional
    public BatchStockResponseDTO updateInboundorder(InboundorderRequestDTO inboundOrderRequestDTO) {
        return createOrUpdatedInbounder(inboundOrderRequestDTO, HttpMethod.PUT);
    }
}
