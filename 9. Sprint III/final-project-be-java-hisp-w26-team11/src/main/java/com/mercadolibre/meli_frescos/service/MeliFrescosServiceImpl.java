package com.mercadolibre.meli_frescos.service;
import com.mercadolibre.meli_frescos.model.Batch;
import com.mercadolibre.meli_frescos.dto.frescos.*;
import com.mercadolibre.meli_frescos.exceptions.ApiException;
import com.mercadolibre.meli_frescos.model.*;
import com.mercadolibre.meli_frescos.exceptions.BadRequestException;
import com.mercadolibre.meli_frescos.exceptions.NotFoundException;
import com.mercadolibre.meli_frescos.model.Product;
import com.mercadolibre.meli_frescos.model.InboundOrder;
import com.mercadolibre.meli_frescos.model.Section;
import com.mercadolibre.meli_frescos.model.Warehouse;
import com.mercadolibre.meli_frescos.repository.*;
import jakarta.transaction.Transactional;
import com.mercadolibre.meli_frescos.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class MeliFrescosServiceImpl implements IMeliFrescosService {

    @Autowired
    IStatusRepository statusRepository;
    @Autowired
    IPurchaseOrderProductRepository purchaseOrderProductRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    IInboundOrderRepository inboundOrderRepository;
    @Autowired
    IBatchRepository batchRepository;
    @Autowired
    ISectionRepository sectionRepository;
    @Autowired
    IWarehouseRepository warehouseRepository;
    @Autowired
    IProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Crea una nueva orden de entrada en el sistema.
     *
     * @param inboundOrderRequestDTO Objeto que contiene la información de la orden de entrada a crear.
     * @return InboundOrderResponseDTO Objeto que contiene la información de la orden de entrada creada.
     * @throws ApiException Si la orden de entrada ya existe, si el almacén no existe, o si la sección no existe.
     */
    @Override
    public InboundOrderResponseDTO createInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        InboundOrder inboundOrderExist = inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber());

        if(inboundOrderExist != null) {
            throw new ApiException("Inbound Order ya existe", "bad_request", 400);
        }

        // Inbound Order
        InboundOrder inboundOrder = modelMapper.map(inboundOrderRequestDTO, InboundOrder.class);


        // Warehouse
        Optional<Warehouse> warehouse = warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode());

        if(warehouse.isEmpty()) {
            throw new ApiException("Warehouse no existe", "bad_request", 400);
        }

        inboundOrder.setSeller(warehouse.get().getRepresentative());

        // Section
        Optional<Section> section = sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode());

        if (section.isEmpty()) {
            throw new ApiException("Section no existe", "bad_request", 400);
        }

        List<Batch> batchList = new ArrayList<>();

       for (BatchStockRequestDTO batchStockRequestDTO : inboundOrderRequestDTO.getInboundOrder().getBatchStock()) {
            Batch batch = new Batch().builder()
                    .batchNumber(batchStockRequestDTO.getBatchNumber())
                    .product(productRepository.findById(batchStockRequestDTO.getProductId()).get())
                    .inboudOrder(inboundOrder)
                    .section(section.get())
                    .currentQuantity(batchStockRequestDTO.getCurrentQuantity())
                    .currentTemperature(batchStockRequestDTO.getCurrentTemperature())
                    .dueDate(batchStockRequestDTO.getDueDate())
                    .initialQuantity(batchStockRequestDTO.getInitialQuantity())
                    .manufacturingDate(batchStockRequestDTO.getManufacturingDate())
                    .manufacturingTime(batchStockRequestDTO.getManufacturingTime())
                    .minimumTemperature(batchStockRequestDTO.getMinimumTemperature())
                    .build();

            batchList.add(batch);
        }

        inboundOrderRepository.save(inboundOrder);

        List<Batch> batchesResponse = batchRepository.saveAll(batchList);

        List<BatchStockResponseDTO> batchStockResponseDTOList =  batchesResponse.stream().map(batch -> modelMapper.map(batch, BatchStockResponseDTO.class)).toList();

        return InboundOrderResponseDTO.builder()
                .batchStock(batchStockResponseDTOList)
                .build();
    }

    /**
     * Actualiza una orden de entrada existente.
     *
     * @param inboundOrderRequestDTO Objeto que contiene la información de la orden de entrada a actualizar.
     * @return InboundOrderResponseDTO Objeto que contiene la información de la orden de entrada actualizada.
     * @throws ApiException Si la orden de entrada no existe, si el almacén no existe, si la sección no existe, si el lote no existe, o si la capacidad de la sección se excede.
     */
    @Override
    public InboundOrderResponseDTO updateInboundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        // Inbound Order
        InboundOrder inboundOrderExist = inboundOrderRepository.findByOrderNumber(inboundOrderRequestDTO.getInboundOrder().getOrderNumber());
        if (inboundOrderExist == null) throw new ApiException("Inbound Order not found", "bad_request", 400);

        InboundOrder inboundOrder = modelMapper.map(inboundOrderRequestDTO, InboundOrder.class);

        Optional<Warehouse> warehouse = warehouseRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getWarehouseCode());
        if(warehouse.isEmpty()) throw new ApiException("Warehouse not found", "bad_request", 400);

        inboundOrder.setSeller(warehouse.get().getRepresentative());
        inboundOrder.setId(inboundOrderExist.getId());

        InboundOrder inboundOrderSaved = inboundOrderRepository.save(inboundOrder);

        // Section
        Optional<Section> section = sectionRepository.findById(inboundOrderRequestDTO.getInboundOrder().getSection().getSectionCode());
        if (section.isEmpty()) throw new ApiException("Section not found", "bad_request", 400);

        // Batches
        Map<Integer, Integer> batchNumberToQuantity = new HashMap<>();

        List<Batch> batches = List.of(modelMapper.map(inboundOrderRequestDTO.getInboundOrder().getBatchStock(), Batch[].class));
        batches.forEach(batch -> {
            Optional<Batch> batchExist = Optional.ofNullable(batchRepository.findByBatchNumber(batch.getBatchNumber()));
            if (batchExist.isEmpty()) throw new ApiException("Batch not found", "bad_request", 400);

            if(!Objects.equals(batchExist.get().getInboudOrder().getOrderNumber(), inboundOrder.getOrderNumber()))
                throw new ApiException("Batch already exists in another Inbound Order", "bad_request", 400);

            batch.setId(batchExist.get().getId());
            batch.setSection(section.get());
            batch.setInboudOrder(inboundOrderSaved);

            batchNumberToQuantity.put(batch.getId(), batch.getCurrentQuantity());
        });

        List<Batch> batchesRepo = batchRepository.findAllBySection(section.get());
        batchesRepo.forEach(batch -> {
            if (batchNumberToQuantity.containsKey(batch.getId())) {
                batch.setCurrentQuantity(batchNumberToQuantity.get(batch.getId()));
            }
        });

        int availableQuantity = new ValidationUtils()
                .getTotalQuantityAvailable(batchesRepo, section.get());
        if (availableQuantity < 0)
            throw new ApiException("Section capacity exceeded", "bad_request", 400);

        List<Batch> batchesUpdate = batchRepository.saveAll(batches);
        List<BatchStockResponseDTO> batchStockResponseDTOS = List.of(modelMapper.map(batchesUpdate, BatchStockResponseDTO[].class));

        return InboundOrderResponseDTO.builder()
                .batchStock(batchStockResponseDTOS)
                .build();
    }


    /**
     *Requerimiento 2.2 - Requerimiento 2.5: Dar de alta una orden. Si la orden existe, editarla.
     *
     */

    @Override
    @Transactional
    public PurchaseResponseDTO registerPurchaseOrder(PurchaseRequestDTO purchaseRequestDTO) {
        User buyer = userRepository.findById(purchaseRequestDTO.getPurchaseOrder().getBuyerId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (buyer.getRole() != Role.BUYER) {
            throw new BadRequestException("El usuario no es un comprador");
        }

        PurchaseOrder purchaseOrder = purchaseOrderRepository.findByBuyer(buyer)
                .orElse(new PurchaseOrder());

        if (purchaseOrder.getId() != null) {
            throw new BadRequestException("La Orden de Venta ya existe");
        }

        updatePurchaseOrderDetails(purchaseOrder, purchaseRequestDTO);

        purchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        double totalCost = processPurchaseOrderProducts(purchaseOrder, purchaseRequestDTO);

        return new PurchaseResponseDTO(totalCost);
    }


    private void updatePurchaseOrderDetails(PurchaseOrder purchaseOrder, PurchaseRequestDTO purchaseRequestDTO) {
        purchaseOrder.setBuyer(userRepository.findById(purchaseRequestDTO.getPurchaseOrder().getBuyerId())
                .orElseThrow(() -> new NotFoundException("User not found")));
        purchaseOrder.setDate(purchaseRequestDTO.getPurchaseOrder().getDate());

        Status status = statusRepository.findByStatusCode(purchaseRequestDTO.getPurchaseOrder().getOrderStatus().getStatusCode())
                .orElseThrow(() -> new NotFoundException("Status not found"));
        purchaseOrder.setStatus(status);
    }

    private double processPurchaseOrderProducts(PurchaseOrder purchaseOrder, PurchaseRequestDTO purchaseRequestDTO) {
        List<PurchasedProductDTO> validProducts = new ArrayList<>();

        for (PurchasedProductDTO productDTO : purchaseRequestDTO.getPurchaseOrder().getProducts()) {
            if (validateProductStock(validateProductDueDate(productDTO.getProductId(), purchaseRequestDTO.getPurchaseOrder().getDate().plusDays(20)), productDTO.getQuantity())) {
                validProducts.add(productDTO);
                Product product = productRepository.findById(productDTO.getProductId())
                        .orElseThrow(() -> new NotFoundException("Product not found"));

                PurchaseOrderProduct purchaseOrderProduct = new PurchaseOrderProduct();
                purchaseOrderProduct.setProduct(product);
                purchaseOrderProduct.setPurchaseOrder(purchaseOrder);
                purchaseOrderProduct.setProductQuantity(productDTO.getQuantity());

                purchaseOrderProductRepository.save(purchaseOrderProduct);
            }
        }

        return validProducts.stream()
                .mapToDouble(p -> productRepository.findById(p.getProductId())
                        .orElseThrow(() -> new NotFoundException("Product not found"))
                        .getPrice() * p.getQuantity())
                .sum();
    }

    private List<Batch> validateProductDueDate(Integer productId, LocalDate dueDateLimit) {
        Product purchasedProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        List<Batch> batch = batchRepository.findAllByProduct(purchasedProduct);
        return batch.stream()
                .filter(b -> b.isExpiredBy(dueDateLimit)).toList();
    }

    private Boolean validateProductStock(List<Batch> batches, Integer quantity){
        Double stockQuantity = batches.stream()
                .mapToDouble(Batch::getCurrentQuantity).sum();
        if(quantity <= stockQuantity){
            return true;
        }else {
            throw new BadRequestException("No hay suficiente stock para el producto");
        }

    }


    @Override
    public List<ProductSimpleResponseDTO> listProducts(Optional<String> acronym) {


        List<ProductSimpleResponseDTO> products;

        if(acronym.isPresent())
        {
            products = productRepository.findAllByProductTypeAcronym(acronym.get());
        } else
        {
            products = productRepository.findAll()
                    .stream().map(product -> modelMapper.map(product, ProductSimpleResponseDTO.class))
                    .toList();
        }

        if(products.isEmpty())
        {
            throw new NotFoundException("404 we can't find the products");
        }
        return products;
    }

    /**
     *Requerimiento 2.5: Editar una Orden de Compra existente.
     *
     */
    @Override
    @Transactional
    public PurchaseResponseDTO updatePurchaseOrder(PurchaseRequestDTO purchaseRequestDTO) {
        User buyer = userRepository.findById(purchaseRequestDTO.getPurchaseOrder().getBuyerId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        PurchaseOrder purchaseOrder = purchaseOrderRepository.findByBuyer(buyer)
                .orElseThrow(() -> new NotFoundException("Purchase Order not found"));

        updatePurchaseOrderDetails(purchaseOrder, purchaseRequestDTO);

        purchaseOrderProductRepository.deleteAllByPurchaseOrder(purchaseOrder);

        purchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        double totalCost = processPurchaseOrderProducts(purchaseOrder, purchaseRequestDTO);

        return new PurchaseResponseDTO(totalCost);
    }

    @Override
    public List<ProductSimpleResponseDTO> listProductsFromOrder(Integer orderId) {
        if (isOrderValid(orderId).isEmpty()) {
            throw new NotFoundException("Purchase Order not found");
        }
        return purchaseOrderProductRepository.findProductsByOrderId(orderId);
    }

    @Override
    public ProductBatchesResponseDTO listBatchesOfProduct(Integer idProduct, Optional<String> order) {

        // Obtener el producto por su ID
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ApiException("Product not found", "product_not_found", 404));

        // Calcular la fecha mínima (3 semanas a partir de hoy)
        LocalDate minDueDate = LocalDate.now().plusWeeks(3);

        List<Batch> batches = batchRepository.findByMinDueDate(minDueDate, idProduct);



        if (batches.isEmpty()) {
            throw new ApiException("No batches found for product", "batches_not_found", 404);
        }

        // Validación: El producto debe aparecer en diferentes lotes
        Set<Integer> uniqueBatchNumbers = batches.stream()
                .map(Batch::getBatchNumber)
                .collect(Collectors.toSet());

        if (uniqueBatchNumbers.size() < 2) {
            throw new ApiException("Product must appear in different batches", "product_in_single_batch", 400);
        }

        // Obtener la sección y el almacén de cada lote
        List<BatchDTO> batchDTOs = batches.stream().map(batch -> {
            Section section = sectionRepository.findById(batch.getSection().getId())
                    .orElseThrow(() -> new ApiException("Section not found", "section_not_found", 404));
            Warehouse warehouse = warehouseRepository.findById(section.getWarehouse().getId())
                    .orElseThrow(() -> new ApiException("Warehouse not found", "warehouse_not_found", 404));

            BatchDTO batchDTO = new BatchDTO();
            batchDTO.setBatchNumber(batch.getBatchNumber());
            batchDTO.setCurrentQuantity(batch.getCurrentQuantity());
            batchDTO.setDueTime(batch.getDueDate());

            return batchDTO;
        }).collect(Collectors.toList());

        // Ordenar lotes si se especifica un orden
        if (order.isPresent()) {
            String orderCriteria = order.get().toUpperCase();
            switch (orderCriteria) {
                case "L":
                    batchDTOs.sort(Comparator.comparing(BatchDTO::getBatchNumber));
                    break;
                case "C":
                    batchDTOs.sort(Comparator.comparing(BatchDTO::getCurrentQuantity));
                    break;
                case "F":
                    batchDTOs.sort(Comparator.comparing(BatchDTO::getDueTime));
                    break;
                default:
                    throw new ApiException("Invalid order criteria", "invalid_order_criteria", 400);
            }
        }

        // Crear el DTO de respuesta
        ProductBatchesResponseDTO responseDTO = new ProductBatchesResponseDTO();
        responseDTO.setProductId(Integer.parseInt(idProduct.toString()));

        Section section = sectionRepository.findById(batches.get(0).getSection().getId())
                .orElseThrow(() -> new ApiException("Section not found", "section_not_found", 404));
        Warehouse warehouse = warehouseRepository.findById(section.getWarehouse().getId())
                .orElseThrow(() -> new ApiException("Warehouse not found", "warehouse_not_found", 404));

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSectionCode(section.getSectionCode());
        sectionDTO.setWarehouseCode(warehouse.getWarehouseCode());

        responseDTO.setSection(sectionDTO);
        responseDTO.setBatches(batchDTOs);

        return responseDTO;
    }

    @Override
    public ProductWarehouseResponseDTO listProductStockByWarehouse(Integer idProduct) {
        // Verificar si el producto existe
        if (!productRepository.existsById(idProduct)) {
            throw new ApiException("Product not found", "product_not_found", 404);
        }

        // Obtener la lista de WarehouseDTO
        List<WarehouseDTO> warehouseDTOs = productRepository.findWarehousesAndQuantitiesByProductId(idProduct);

        // Verificar si la lista es vacía
        if (warehouseDTOs.isEmpty()) {
            throw new ApiException("Product not found in any warehouse", "product_not_in_warehouse", 404);
        }

        // Crear el DTO de respuesta
        return new ProductWarehouseResponseDTO(Integer.parseInt(idProduct.toString()), warehouseDTOs);
    }

    @Override
    public BatchSearchStockResponseDTO listOrderedDueDateProducts(Integer days, Optional<String> productTypeAcronym, Optional<String> order) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(days);

        List<Batch> batches;

        if (productTypeAcronym.isPresent()) {
            String productType = productTypeAcronym.get();
            Integer productTypeId = mapProductTypeAcronymToProductTypeId(productType);
            batches = batchRepository.findByDueDateAndProductType(currentDate, futureDate, productTypeId);
        } else {
            batches = batchRepository.findByDueDate(currentDate, futureDate);
        }

        if (order.isPresent()) {
            batches.sort(getComparator(order.get()));
        }

        List<BatchStockExtendedDTO> batchStockExtendedDTOList = batches.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        BatchSearchStockResponseDTO response = new BatchSearchStockResponseDTO();
        response.setBatchStockExtendedDTOList(batchStockExtendedDTOList);
        return response;
    }
    private Integer mapProductTypeAcronymToProductTypeId(String productTypeAcronym) {
        switch (productTypeAcronym.toUpperCase()) {
            case "FS":
                return 1; // Fresco
            case "RF":
                return 2; // Refrigerado
            case "FF":
                return 3; // Congelado
            default:
                throw new IllegalArgumentException("Invalid product type acronym");
        }
    }

    private Comparator<Batch> getComparator(String order) {
        if (order.equalsIgnoreCase("date_desc")) {
            return Comparator.comparing(Batch::getDueDate).reversed();
        } else {
            return Comparator.comparing(Batch::getDueDate);
        }
    }

    private BatchStockExtendedDTO convertToDto(Batch batch) {
        BatchStockExtendedDTO batchStockExtendedDTO = new BatchStockExtendedDTO();
        batchStockExtendedDTO.setBatchNumber(batch.getBatchNumber());
        batchStockExtendedDTO.setCurrentQuantity(batch.getCurrentQuantity());
        batchStockExtendedDTO.setDueDate(batch.getDueDate());
        batchStockExtendedDTO.setProductId(batch.getProduct().getId());
        batchStockExtendedDTO.setProductTypeId(batch.getSection().getProductType().getId());
        return batchStockExtendedDTO;
    }

    private Optional<PurchaseOrder> isOrderValid(Integer order) {
        return purchaseOrderRepository.findById(order);
    }
}
