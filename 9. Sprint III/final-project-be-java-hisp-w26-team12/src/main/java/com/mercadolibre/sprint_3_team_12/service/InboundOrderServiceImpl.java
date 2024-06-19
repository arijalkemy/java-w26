package com.mercadolibre.sprint_3_team_12.service;

import com.mercadolibre.sprint_3_team_12.dto.SectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.*;
import com.mercadolibre.sprint_3_team_12.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint_3_team_12.entity.*;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.mercadolibre.sprint_3_team_12.dto.response.*;
import com.mercadolibre.sprint_3_team_12.enums.OrderStatus;
import com.mercadolibre.sprint_3_team_12.enums.Rol;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiError;
import com.mercadolibre.sprint_3_team_12.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for handling inbound orders.
 */
@Service
public class InboundOrderServiceImpl implements IInboundOrderService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IInboundOrderRepository inboundOrderRepository;
    @Autowired
    ISectionRepository sectionRepository;
    @Autowired
    IWarehouseRepository warehouseRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IBatchStockRepository batchStockRepository;
    @Autowired
    IProductInCartRepository productInCartRepository;
    @Autowired
    ICartRepository cartRepository;

    /**
     * Method to register an inbound order.
     *
     * @param inboundDTO the inbound order data transfer object
     * @param isUpdate whether the operation is an update
     * @return the inbound response data transfer object
     */
    @Transactional
    @Override
    public InboundResponseDTO registerInboundOrder(InboundDTO inboundDTO, Boolean isUpdate) {
        User user = getUserFromAuthentication();

        InboundOrderDTO inboundOrderDTO = inboundDTO.getInboundOrder();
        List<BatchDTO> batchDTOList = inboundOrderDTO.getBatchDTOList();
        SectionDTO sectionDTO = inboundOrderDTO.getSectionDTO();

        Warehouse warehouse = getWarehouse(sectionDTO, user);
        Section section = getSection(sectionDTO, warehouse);
        validateCapacity(section, batchDTOList);

        InboundOrder inboundOrder = createInboundOrderBuilder(inboundOrderDTO, section, user, isUpdate);
        Category category = Category.valueOf(section.getType().toString());

        List<BatchStock> batchStocks = createBatchStocks(batchDTOList, category, inboundOrder);

        inboundOrderRepository.save(inboundOrder);
        batchStockRepository.saveAll(batchStocks);

        return InboundResponseDTO.builder()
                .batchDTOList(batchDTOList)
                .build();
    }

    /**
     * Method to get user from authentication.
     *
     * @return the user
     */
    private User getUserFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userRepository.findByUsername(currentPrincipalName)
                .orElseThrow(null);
    }

    /**
     * Method to get warehouse.
     *
     * @param sectionDTO the section data transfer object
     * @param user the user
     * @return the warehouse
     */
    private Warehouse getWarehouse(SectionDTO sectionDTO, User user) {
        List<User> people = new ArrayList<>();
        people.add(user);
        return warehouseRepository.findByIdAndPeople(sectionDTO.getWarehouseCode().longValue(),people)
                .orElseThrow(() -> new ApiException(
                        "Warehouse not found",
                        "Warehouse with id " + sectionDTO.getWarehouseCode() + " not found or user does not have access",
                        HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Method to get section.
     *
     * @param sectionDTO the section data transfer object
     * @param warehouse the warehouse
     * @return the section
     */
    private Section getSection(SectionDTO sectionDTO, Warehouse warehouse) {
        return sectionRepository.findByIdAndWarehouse(sectionDTO.getSectionCode().longValue(), warehouse)
                .orElseThrow(() -> new ApiException(
                        "Section not found",
                        "Section with id " + sectionDTO.getSectionCode() + " not found in warehouse with id " + sectionDTO.getWarehouseCode(),
                        HttpStatus.NOT_FOUND.value()));
    }

    /**
     * Method to validate capacity of the section.
     *
     * @param section the section
     * @param batchDTOList the list of batch data transfer objects
     */
    private void validateCapacity(Section section, List<BatchDTO> batchDTOList) {
        Integer capacity = section.getCapacity();
        Integer occupiedCapacity = section.getInboundOrders().stream()
                .map(InboundOrder::getBatchStocks)
                .flatMap(List::stream)
                .mapToInt(BatchStock::getCurrentQuantity)
                .sum();
        int availableCapacity = capacity - occupiedCapacity;
        int neededCapacity = batchDTOList.stream()
                .mapToInt(BatchDTO::getCurrentQuantity)
                .sum();

        if (neededCapacity > availableCapacity) {
            throw new ApiException(
                    "Insufficient capacity",
                    "Section with id " + section.getId() + " does not have enough capacity to store the requested products",
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Method to create inbound order builder.
     *
     * @param inboundOrderDTO the inbound order data transfer object
     * @param section the section
     * @param user the user
     * @param isUpdate whether the operation is an update
     * @return the inbound order
     */
    private InboundOrder createInboundOrderBuilder(InboundOrderDTO inboundOrderDTO, Section section, User user, Boolean isUpdate) {

        if (inboundOrderRepository.findByOrderNumberAndUser(inboundOrderDTO.getOrderId().longValue(), user).isPresent()) {
            if (isUpdate) {
                InboundOrder inboundOrder = inboundOrderRepository.findByOrderNumberAndUser(inboundOrderDTO.getOrderId().longValue(), user).get();
                inboundOrder.setOrderDate(inboundOrderDTO.getOrderDate());
                return inboundOrder;
            }
            throw new ApiException(
                    "Inbound order already exists",
                    "Inbound order with id " + inboundOrderDTO.getOrderId() + " already exists for your user, if you want to update it, please set the correct endpoint",
                    HttpStatus.CONFLICT.value());
        }
        if (isUpdate) {
            throw new ApiException(
                    "Inbound order not found",
                    "Inbound order with id " + inboundOrderDTO.getOrderId() + " not found for your user",
                    HttpStatus.NOT_FOUND.value());
        }

        return InboundOrder.builder()
                .orderNumber(inboundOrderDTO.getOrderId().longValue())
                .orderDate(inboundOrderDTO.getOrderDate())
                .section(section)
                .user(user)
                .build();
    }

    /**
     * Method to create batch stocks.
     *
     * @param batchDTOList the list of batch data transfer objects
     * @param category the category
     * @param inboundOrder the inbound order
     * @return the list of batch stocks
     */
    private List<BatchStock> createBatchStocks(List<BatchDTO> batchDTOList, Category category, InboundOrder inboundOrder) {
        List<BatchStock> batchStocks = new ArrayList<>();
        validateUniqueProductId(batchDTOList);
        validateUniqueBatchNumbers(batchDTOList);
        for (BatchDTO batchDTO : batchDTOList) {
            batchStocks.add(createBatchStock(batchDTO, category, inboundOrder));
        }
        return batchStocks;
    }

    /**
     * Method to create batch stock.
     *
     * @param batchDTO the batch data transfer object
     * @param category the category
     * @param inboundOrder the inbound order
     * @return the batch stock
     */
    private BatchStock createBatchStock(BatchDTO batchDTO, Category category, InboundOrder inboundOrder) {
        Long idProduct = batchDTO.getIdProduct().longValue();
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ApiException(
                        "Product not found",
                        "Product with id " + idProduct + " in batch number " + batchDTO.getIdBatch() + " not found",
                        HttpStatus.NOT_FOUND.value()));

        validateProductCategory(product, category, idProduct);
        validateDates(batchDTO, idProduct);

        return BatchStock.builder()
                .id(batchDTO.getIdBatch().longValue())
                .currentTemperature(batchDTO.getCurrentTemperature())
                .minimumTemperature(batchDTO.getMinimunTemperature())
                .initialQuantity(batchDTO.getInitialQuantity())
                .currentQuantity(batchDTO.getCurrentQuantity())
                .manufacturingDate(batchDTO.getManufacturingDate())
                .manufacturingTime(batchDTO.getManufacturingTime())
                .dueDate(batchDTO.getDueDate())
                .product(product)
                .inboundOrder(inboundOrder)
                .build();
    }

    /**
     * Method to validate product category.
     *
     * @param product the product
     * @param category the category
     * @param idProduct the product id
     */
    private void validateProductCategory(Product product, Category category, Long idProduct) {
        if (!product.getType().equals(category)) {
            throw new ApiException(
                    "Invalid product category",
                    "Product with id " + idProduct + " does not match the expected category in the selected section with category " + category,
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Method to validate dates.
     *
     * @param batchDTO the batch data transfer object
     * @param idProduct the product id
     */
    private void validateDates(BatchDTO batchDTO, Long idProduct) {
        Date dueDate = batchDTO.getDueDate();
        Date manufacturingDate = batchDTO.getManufacturingDate();
        if (dueDate.before(new Date())) {
            throw new ApiException(
                    "Invalid due date",
                    "Due date for product with id " + idProduct + " in batch number " + batchDTO.getIdBatch() + " is in the past",
                    HttpStatus.BAD_REQUEST.value());
        }
        if (dueDate.before(manufacturingDate)) {
            throw new ApiException(
                    "Invalid manufacturing date",
                    "Manufacturing date for product with id " + idProduct + " in batch number " + batchDTO.getIdBatch() + " is in the past of the due date",
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Method to validate unique product id.
     *
     * @param batchDTOList the list of batch data transfer objects
     */
    private void validateUniqueProductId(List<BatchDTO> batchDTOList) {
        Set<Integer> productIds = batchDTOList.stream()
                .map(BatchDTO::getIdProduct)
                .collect(Collectors.toSet());
        if (productIds.size() != batchDTOList.size()) {
            throw new ApiException(
                    "Duplicated product id",
                    "There are duplicated product ids in the batch list",
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Method to validate unique batch numbers.
     *
     * @param batchDTOList the list of batch data transfer objects
     */
    private void validateUniqueBatchNumbers(List<BatchDTO> batchDTOList) {
        Set<Integer> batchNumbers = batchDTOList.stream()
                .map(BatchDTO::getIdBatch)
                .collect(Collectors.toSet());
        if (batchNumbers.size() != batchDTOList.size()) {
            throw new ApiException(
                    "Duplicated batch number",
                    "There are duplicated batch numbers in the batch list",
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Service that adds a cart with the inbound order and the batch
     * @param cartDTO
     * @return
     */
    @Override
    public CartWithErrorsResponseDTO createInBoundOrder(CartDTO cartDTO) {
        return processOrder(cartDTO, null);
    }

    @Override
    public CartWithErrorsResponseDTO updateInBoundOrder(CartDTO cartDTO, Long idOrder) {
        return processOrder(cartDTO, idOrder);
    }

    private CartWithErrorsResponseDTO processOrder(CartDTO cartDTO, Long idOrder) {
        PurchaseOrderDTO purchaseOrderDTO = cartDTO.getPurchaseOrder();
        User user = validateUser(Integer.toUnsignedLong(cartDTO.getPurchaseOrder().getIdBuyer()));

        List<ApiError> errors = new ArrayList<>();
        List<ProductInCart> productsInCarts = new ArrayList<>();
        Double totalPrice = 0.0;

        for (ProductDTO productDTO : purchaseOrderDTO.getProductDTO()) {
            Optional<Product> optionalProduct = productRepository.findById((long) productDTO.getIdProduct());
            if (!optionalProduct.isPresent()) {
                errors.add(new ApiError("Not Found", "Product not found", 404));
                continue;
            }
            Product product = optionalProduct.get();
            int totalStocks = batchStockRepository.getBatchStocksByProductId(Integer.toUnsignedLong(productDTO.getIdProduct()))
                    .stream()
                    .mapToInt(BatchStock::getCurrentQuantity)
                    .sum();
            if (totalStocks - productDTO.getQuantity() < 0) {
                errors.add(new ApiError("Not enough stock", "Not enough stock in the batches with product " + product.getName() + ", missing " + (productDTO.getQuantity() - totalStocks), 404));
                continue;
            }
            totalPrice += productDTO.getQuantity() * product.getPrice();
            productsInCarts.add(ProductInCart.builder()
                    .quantity(productDTO.getQuantity())
                    .product(Product.builder().id(product.getId()).build())
                    .build());
        }

        if (!errors.isEmpty()) {
            return new CartWithErrorsResponseDTO(errors);
        }

        Cart cart = Cart.builder()
                .id(idOrder)
                .carDate(purchaseOrderDTO.getDate())
                .orderStatus(OrderStatus.CARRITO)
                .totalPrice(totalPrice)
                .buyer(user)
                .build();

        cartRepository.save(cart);
        productsInCarts.forEach(productInCart -> {
            productInCart.setCart(cart);
            productInCartRepository.save(productInCart);
        });

        return new CartWithErrorsResponseDTO(totalPrice);
    }

    private User validateUser(Long idBuyer) {
        Optional<User> optionalUser = userRepository.findById(idBuyer);
        if (!optionalUser.isPresent()) {
            throw new ApiException("Not Found", "User doesn't exist", 404);
        }
        User user = optionalUser.get();
        if (!user.getRole().equals(Rol.USER)) {
            throw new ApiException("Not Found", "Id isn't a user", 404);
        }
        return user;
    }


}

