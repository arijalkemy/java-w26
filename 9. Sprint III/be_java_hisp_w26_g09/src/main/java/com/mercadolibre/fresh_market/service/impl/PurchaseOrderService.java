package com.mercadolibre.fresh_market.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.config.NoRolePermitionsException;
import com.mercadolibre.fresh_market.config.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.UserNotFoundException;
import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.dtos.ProductDTO;
import com.mercadolibre.fresh_market.dtos.ProjectionPurchaseOrder;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.dtos.Response;
import com.mercadolibre.fresh_market.dtos.ResponseDTO;
import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.exceptions.NoStockAvavility;
import com.mercadolibre.fresh_market.exceptions.StatusInvalidException;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.OrderStatus;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
import com.mercadolibre.fresh_market.service.IPurchaseOrderService;
import com.mercadolibre.fresh_market.service.IPurchaseOrderValidationService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {


    @Autowired
    private IPurchaseOrderRepository puchaseOrderRepository;

    @Autowired
    private ICartDetailRepository cartDetailRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IBatchRepository batchRepository;

    @Autowired
    private IUserRepository userRepository;

    //Auxiliar services
    @Autowired
    IPurchaseOrderValidationService purchaseOrderValidationService;

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JwtService jwtService;


    /**
     * Modifies the existence of a Purchase Order.
     * This method checks if the user has the correct role, validates the order status,
     * calculates the total stock, and updates the purchase order in the database.
     *
     * @param orderId The ID of the order to modify.
     * @param purchaseOrderDTO The data transfer object containing the new details of the order.
     * @return A ResponseDTO object with a success message and the total price of the order.
     * @throws NoRolePermitionsException if the user does not have the correct role.
     * @throws NoStockAvavility if there is not enough stock for the order.
     * @throws StatusInvalidException if the order status is invalid.
     */
    @Override
    @PreAuthorize("hasRole('ROLE_BUYER')")
    public ResponseDTO modifyOrderExistence(Long orderId, PurchaseOrderDTO purchaseOrderDTO) {

        PurchaseOrder purchaseOrder = puchaseOrderRepository.findById(orderId).orElse(null);
        if (purchaseOrder == null) {
            throw new NoRolePermitionsException("Order not found");
        }

        purchaseOrder.setDate(purchaseOrderDTO.getDate());

        ShoppingCartKey shoppingCartKey = new ShoppingCartKey();
        shoppingCartKey.setOrderId(orderId);

        List<CartDetail> cartDetails = cartDetailRepository.findById_OrderId(orderId);
        cartDetailRepository.deleteAll(cartDetails);


        List<CartDetail> newCartDetailsList = purchaseOrderDTO.getProducts()
                .stream()
                .map(productDTO -> {
                    Product product = productRepository.findById(productDTO.getProductId())
                            .orElseThrow(() -> new ProductNotFoundException("Product not found"));

                    if(!isUserValid(purchaseOrderDTO.getBuyerId())){
                        throw new UserNotFoundException("User not found");
                    }


                    if (!isOrderStatusValid(purchaseOrderDTO.getOrder_status().getStatusCode())) {
                        throw new StatusInvalidException("Invalid order status: " + purchaseOrderDTO.getOrder_status());
                    }

                    int totalStock = calculateTotalStockAnd3Week(product);
                    if (totalStock < productDTO.getQuantity()) {
                        throw new NoStockAvavility("Insufficient stock");
                    }

                    // Crea un nuevo detalle del carrito
                    CartDetail newCartDetail = new CartDetail();
                    newCartDetail.setProduct(product);
                    newCartDetail.setQuantity(productDTO.getQuantity());
                    newCartDetail.setPurchaseOrder(purchaseOrder);

                    // Set productId in ShoppingCartKey
                    ShoppingCartKey shoppingCartKey1 = new ShoppingCartKey();
                    shoppingCartKey1.setOrderId(orderId);
                    shoppingCartKey1.setProductId(productDTO.getProductId());
                    newCartDetail.setId(shoppingCartKey1);

                    cartDetailRepository.save(newCartDetail);

                    return newCartDetail;
                })
                .toList();


        double totalPrice = newCartDetailsList.stream()
                .mapToDouble(cartDetail -> cartDetail.getProduct().getPrice() * cartDetail.getQuantity())
                .sum();


        // Set new cart details list
        purchaseOrder.setCartDetails(newCartDetailsList);

        puchaseOrderRepository.save(purchaseOrder);

        return new ResponseDTO("Updated successfully",totalPrice);
    }

    /**
     * Calculates the total stock of a product that is not due in the next three weeks.
     *
     * @param product The product to calculate the stock for.
     * @return The total stock of the product.
     */
    private int calculateTotalStockAnd3Week(Product product) {
        List<Batch> batches = batchRepository.findByProduct(product);
        List<Batch> filteredBatches = batches.stream()
                .filter(batch -> {
                    LocalDate threeWeeksAgo = LocalDate.now().minusWeeks(3);
                    LocalDate today = LocalDate.now();
                    return !batch.getDueDate().isBefore(threeWeeksAgo) && !batch.getDueDate().isAfter(today);
                })
                .toList();

        int totalStock = 0;
        for (Batch batch : batches) {
            totalStock += batch.getCurrentQuantity();
        }
        return totalStock;

    }

    /**
     * Checks if a user with the given ID exists in the database.
     *
     * @param userId The ID of the user to check.
     * @return true if the user exists, false otherwise.
     * @throws NoRolePermitionsException if the user does not exist.
     */
    public boolean isUserValid(Long userId)
    {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new NoRolePermitionsException("User not found");
        }

        return true;
    }

    /**
     * Checks if the given order status is valid.
     *
     * @param status The status to check.
     * @return true if the status is valid, false otherwise.
     */
    public boolean isOrderStatusValid(String status) {
        try {
            OrderStatus.forValue(status);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    @Override
    @PreAuthorize("hasRole('ROLE_BUYER')")
    public Response createPurcharseOrder(PurchaseOrderDTO purchaseOrderDTO, UserDetails userDetails) {

        User buyer = userService.getUserByEmail(userDetails.getUsername());

        List<ProductDTO> productsToValidate = new ArrayList<>(purchaseOrderDTO.getProducts());
        List<Product> products = this.purchaseOrderValidationService.validateExistenceProducts(productsToValidate);

        //Stock validation
        Double totalPrice = this.purchaseOrderValidationService.validateStock(products, productsToValidate);

        //Creation
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setOrderStatus(OrderStatus.SHOPPING_CART);
        purchaseOrder.setBuyer(buyer);
        puchaseOrderRepository.save(purchaseOrder);

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            ProductDTO productDTO = productsToValidate.get(i);

            ShoppingCartKey id = new ShoppingCartKey(purchaseOrder.getId(), product.getId());
            CartDetail cartDetail = new CartDetail(id, purchaseOrder, product, productDTO.getQuantity());
            cartDetailRepository.save(cartDetail);
        }

        return Response.builder().result(Map.of("total_price", totalPrice)).build();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_BUYER')")
    @Transactional
    public ProjectionPurchaseOrder getProductsByPurchaseOrder(Long idOrder) {
        Optional<PurchaseOrder> optional = this.puchaseOrderRepository.findById(idOrder);
        if (!optional.isPresent()) {
            throw new EntityNotFound("The purchase order with id " + idOrder + " was not found.");
        }
        PurchaseOrder purchaseOrder = optional.get();

        ProjectionPurchaseOrder projectionPurchaseOrder = this.objectMapper.convertValue(purchaseOrder, ProjectionPurchaseOrder.class);
        
        return projectionPurchaseOrder;
    }
}
