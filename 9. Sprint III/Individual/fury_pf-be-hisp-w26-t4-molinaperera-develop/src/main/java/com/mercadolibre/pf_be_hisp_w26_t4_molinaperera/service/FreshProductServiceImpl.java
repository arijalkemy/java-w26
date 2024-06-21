package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.BatchDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductLocationDto;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.*;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.*;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.projection.BatchWithLocation;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.util.BatchLocationMapper;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.util.BatchOrder;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreshProductServiceImpl implements IFreshProductService {

    private final IInboundOrderRepository inboundOrderRepository;
    private final IBatchRepository batchRepository;
    private final IProductRepository productRepository;
    private final IWarehouseRepository warehouseRepository;
    private final ISectionRepository sectionRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ProductLocationDto> getProductLocationsByType(User user, BatchOrder order, Long idProduct) {
        return switch (order) {
            case C -> getProductLocationsOrderByCurrentQuantity(user, idProduct);
            case F -> getProductLocationsOrderByDueDate(user, idProduct);
            default -> getProductLocationsOrderByBatch(user, idProduct);
        };
    }

    @Override
    public List<ProductLocationDto> getProductLocationsOrderByBatch(User user, Long productId) {
        List<BatchWithLocation> locations = batchRepository.findByProductIdOrderById(user.getId(), productId);
        return getProductLocationDtos(locations);
    }

    private static List<ProductLocationDto> getProductLocationDtos(
            List<BatchWithLocation> locations
    ) {
        return BatchLocationMapper.createProductLocationDtos(getLocationsBySection(locations));
    }

    private List<ProductLocationDto> getProductLocationsOrderByDueDate(User user, Long idProduct) {
        List<BatchWithLocation> locations = batchRepository
                .findByProductIdOrderByDueDate(user.getId(), idProduct);

        return getProductLocationDtos(locations);
    }

    private List<ProductLocationDto> getProductLocationsOrderByCurrentQuantity(
            User user, Long idProduct
    ) {
        List<BatchWithLocation> locations = batchRepository
                .findByProductIdOrderByCurrentQuantity(user.getId(), idProduct);

        return getProductLocationDtos(locations);
    }

    private static Map<Long, List<BatchWithLocation>> getLocationsBySection(
            List<BatchWithLocation> locations
    ) {
        return locations.stream().collect(Collectors.groupingBy(BatchWithLocation::getSectionId));
    }

    @Override
    public List<BatchDTO> addInboundOrder(InboundOrderRequestDTO inboundOrderDTO, User user) throws Exception {

        Warehouse warehouse = checkIfUserIsOwnerOfWarehouse(inboundOrderDTO.getSection().getWarehouseCode(), user);

        if (checkInboundOrderExist(inboundOrderDTO)) {
            throw new AlreadyExistException("The inboundOrder already exist"); // falta crear excepcion notFound
        }

        InboundOrder inboundOrder = checkInboundOrderHasCorrectParamsFromDTOandReturnEntity(inboundOrderDTO);
        inboundOrder.setWarehouse(warehouse);
        checkBatchesAreValidAndSaveOrderWithBatches(inboundOrder, inboundOrderDTO);
        return generateBatchDTOsFromInboundOrder(inboundOrderDTO);
    }

    @Override
    public List<BatchDTO> updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO, User user) throws Exception {
        Warehouse warehouse = checkIfUserIsOwnerOfWarehouse(inboundOrderRequestDTO.getSection().getWarehouseCode(), user);

        if (!checkInboundOrderExist(inboundOrderRequestDTO)) {
            throw new NotFoundException("The inboundOrder doesn't exist"); // falta crear excepcion notFound
        }

        InboundOrder inboundOrder = checkInboundOrderHasCorrectParamsFromDTOandReturnEntity(inboundOrderRequestDTO);
        inboundOrder.setWarehouse(warehouse);
        checkBatchesAreValidAndSaveOrderWithBatches(inboundOrder, inboundOrderRequestDTO);
        return generateBatchDTOsFromInboundOrder(inboundOrderRequestDTO);
    }

    // utils functions for services

    private void checkInboundOrderHasCorrectParams(InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        StringBuilder errors = new StringBuilder();

        //check and get section or else throw exception
        Long sectionId = inboundOrderRequestDTO.getSection().getId();
        Optional<Section> sectionOpt = findEntityById(sectionId, sectionRepository);
        if (sectionOpt.isEmpty()) throw new NotFoundException("The section with " + sectionId + " doesn't exist");

        checkSectionHasSufficientStock(sectionOpt.get(), inboundOrderRequestDTO);

        //check all products of batchses are valid for section
        List<Long> productIds = inboundOrderRequestDTO.getBatchList().stream()
                .map(BatchDTO::getProductId)
                .toList();

        productIds.forEach(
                id -> checkProductIsValidForSection(errors, id, sectionOpt.get())
        );

        if (!errors.isEmpty()) throw new BadRequestException(errors.toString());
    }

    private Warehouse checkIfUserIsOwnerOfWarehouse(Long warehouseId, User user) throws Exception {
        Optional<Warehouse> warehouseOpt = warehouseRepository.findById(warehouseId);
        Warehouse warehouse = warehouseOpt.orElseThrow(() -> new NotFoundException("Warehouse not found"));

        Hibernate.initialize(warehouse.getManagerList());

        boolean userIsOwnerOfWarehouse = warehouse.getManagerList().stream()
                .anyMatch(u -> u.getId().equals(user.getId()));

        if (!userIsOwnerOfWarehouse) {
            throw new NotAuthorizedException("The user is not owner of this warehouse");
        }

        return warehouse;
    }


    private List<BatchDTO> generateBatchDTOsFromInboundOrder(InboundOrderRequestDTO inboundOrderDTO) {
        return inboundOrderDTO.getBatchList().stream().map(
                b -> mapper.map(b, BatchDTO.class)
        ).toList();
    }

    private InboundOrder checkInboundOrderHasCorrectParamsFromDTOandReturnEntity(InboundOrderRequestDTO inboundOrderDTO) throws Exception {
        checkInboundOrderHasCorrectParams(inboundOrderDTO);
        return mapper.map(inboundOrderDTO, InboundOrder.class);
    }

    private void checkProductIsValidForSection(StringBuilder errors, Long productId, Section section) {
        Optional<Product> productOpt = findEntityById(productId, productRepository);
        if (productOpt.isEmpty()) {
            errors.append(
                    String.format("The product with id %d doesn't exist.\n", productId)
            );
        } else {
            if (!productAndSectionSameType(productOpt.get(), section)) {
                errors.append(
                        String.format("The product with id %d can't be saved in this type of section.\n", productId)
                );
            }
        }
    }

    private boolean productAndSectionSameType(Product product, Section section) {
        return product.getProductType().equals(section.getProductType());
    }

    private boolean checkInboundOrderExist(InboundOrderRequestDTO inboundOrderRequestDTO) {
        return inboundOrderRepository.findById(inboundOrderRequestDTO.getId()).isPresent();
    }

    private <T> Optional<T> findEntityById(Long id, JpaRepository<T, Long> repository) {
        return repository.findById(id);
    }

    private void checkBatchesAreValidAndSaveOrderWithBatches(InboundOrder order, InboundOrderRequestDTO inboundOrderDTO) {
        List<BatchDTO> batchesDTO = inboundOrderDTO.getBatchList();
        checkBatchAreValidsForInboundOrder(batchesDTO, inboundOrderDTO.getId());
        List<Batch> batches = saveBatches(batchesDTO,order);
        order.setBatchList(batches);
        inboundOrderRepository.save(order);
    }

    private void checkSectionHasSufficientStock(Section section, InboundOrderRequestDTO inbounceOrder) throws Exception {
        int requiredStock = inbounceOrder.getBatchList().stream()
                .mapToInt(BatchDTO::getCurrentQuantity).sum();
        if (section.getCapacity() < requiredStock)
            throw new InsufficientStockException("This section has not sufficient stock");
    }

    private void checkBatchAreValidsForInboundOrder(List<BatchDTO> batchesDTO, Long orderId) {
        for (BatchDTO batchDTO : batchesDTO) {
            Optional<Batch> batchOpt = batchRepository.findById(batchDTO.getId());
            if (batchOpt.isPresent()) {
                if (!batchOpt.get().getInboundOrder().getId().equals(orderId)) {
                    throw new BadRequestException("The batch " + batchDTO.getId() + " correspond to another order");
                }
            }
        }
    }

    private List<Batch> saveBatches(List<BatchDTO> batchesDTO, InboundOrder order){
        List<Batch> batches = new ArrayList<>();
        for (BatchDTO batchDTO : batchesDTO) {
            Batch batch = mapper.map(batchDTO, Batch.class);
            batches.add(batch);
            batchRepository.save(batch);
        }
        return batches;
    }
}
