package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.errors.SimpleProductErrorDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.order.ProductPurchaseOrderCheckDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductPurchaseOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.PurchaseOrderDetailsRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.mapper.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IOrderService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    private final IBuyerRepository buyerRepository;
    private final IStateRepository statusRepository;
    private final IProductSellerRepository productSellerRepository;
    private final IOrderProductSellerRepository orderProductSellerRepository;
    private final IBatchRepository batchRepository;
    private final IOrderRepository orderRepository;

    public OrderServiceImpl(@Autowired IBuyerRepository buyerRepository,
                            @Autowired IStateRepository statusRepository,
                            @Autowired IProductSellerRepository productSellerRepository,
                            @Autowired IOrderProductSellerRepository orderProductSellerRepository,
                            @Autowired IBatchRepository batchRepository,
                            @Autowired IOrderRepository orderRepository) {
        this.buyerRepository = buyerRepository;
        this.statusRepository = statusRepository;
        this.productSellerRepository = productSellerRepository;
        this.orderProductSellerRepository = orderProductSellerRepository;
        this.batchRepository = batchRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public TotalPriceResponseDTO saveProductList(PurchaseOrderRequestDTO purchaseOrderRequestDTO) {
        PurchaseOrderDetailsRequestDTO purchaseOrderDto = purchaseOrderRequestDTO.getPurchaseOrder();

        Buyer buyer = buyerRepository
                .findById(Long.valueOf(purchaseOrderDto.getBuyerId()))
                .orElseThrow(() -> new NotFoundException(MessageError.BUYER_NOT_FOUND.getMessage()));

        Boolean buyerHasPendingOrder = orderRepository.existsByBuyerId(buyer.getId());
        if (buyerHasPendingOrder) {
            throw new BadRequestException(MessageError.USER_ALREADY_HAS_AN_ORDER.getMessage());
        }

        Status status = statusRepository
                .findFirstByDescription(purchaseOrderDto.getOrderStatus().getStatusCode())
                .orElseThrow(() -> new NotFoundException(MessageError.STATUS_NOT_FOUND.getMessage()));

        if (purchaseOrderDto.getProducts().isEmpty()) {
            throw new BadRequestException(MessageError.PRODUCT_LIST_NOT_EXIST.getMessage());
        }

        ProductPurchaseOrderCheckDTO purchaseOrderCheckDTO = performChecksOnProductList(purchaseOrderDto.getProducts());

        List<OrderProductSeller> orderProductSellerList = purchaseOrderCheckDTO.getOrderProductSellerList();
        List<SimpleProductErrorDto> responseErrorList = purchaseOrderCheckDTO.getResponseErrorList();
        double orderTotal = purchaseOrderCheckDTO.getOrderTotal();

        Order newOrder = new Order();
        newOrder.setTotal(BigDecimal.valueOf(orderTotal));
        newOrder.setBuyer(buyer);
        newOrder.setStatus(status);
        newOrder.setDate(purchaseOrderDto.getDate());
        Order createdOrder = orderRepository.save(newOrder);

        orderProductSellerList.forEach((product) -> product.setOrder(createdOrder));
        orderProductSellerRepository.saveAll(orderProductSellerList);

        TotalPriceResponseDTO responseDTO = TotalPriceResponseDTO
                .builder()
                .totalPrice(orderTotal)
                .build();

        if (!responseErrorList.isEmpty()) {
            responseDTO.setProductErrorDto(responseErrorList);
        }
        return responseDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findProductsByOrder(Long idOrder) {
        orderRepository.findById(idOrder).orElseThrow(
                () -> new NotFoundException(MessageError.ORDER_NOT_FOUND.getMessage(idOrder))
        );

        List<IProductResponseProjection> products = productSellerRepository.findAllByOrderId(idOrder);
        if (products.isEmpty()) {
            throw new NotFoundException(MessageError.PRODUCTS_NOT_FOUND.getMessage());
        }

        return products.stream().map(ProductMapper::mapToProductResponseDto).toList();
    }

    @Override
    @Transactional
    public TotalPriceResponseDTO updateProductList(Long idOrder, PurchaseOrderRequestDTO purchaseOrderRequestDTO) {
        Order order = orderRepository.findById(idOrder).orElseThrow(
                () -> new NotFoundException(MessageError.ORDER_NOT_FOUND.getMessage(idOrder))
        );

        PurchaseOrderDetailsRequestDTO purchaseOrderDto = purchaseOrderRequestDTO.getPurchaseOrder();
        Long requestBuyerId = Long.valueOf(purchaseOrderDto.getBuyerId());
        if (!order.getBuyer().getId().equals(requestBuyerId)) {
            throw new BadRequestException(MessageError.BUYER_NOT_MATCHES_ORDER.getMessage(requestBuyerId));
        }

        String requestStatusName = purchaseOrderDto.getOrderStatus().getStatusCode();
        if (!requestStatusName.equals("carrito")) {
            throw new BadRequestException(MessageError.STATUS_INVALID.getMessage());
        }

        if (purchaseOrderDto.getProducts().isEmpty()) {
            throw new BadRequestException(MessageError.PRODUCT_LIST_NOT_EXIST.getMessage());
        }

        ProductPurchaseOrderCheckDTO purchaseOrderCheckDTO = performChecksOnProductList(purchaseOrderDto.getProducts());

        List<OrderProductSeller> orderProductSellerList = purchaseOrderCheckDTO.getOrderProductSellerList();
        List<SimpleProductErrorDto> responseErrorList = purchaseOrderCheckDTO.getResponseErrorList();
        double orderTotal = purchaseOrderCheckDTO.getOrderTotal();

        orderProductSellerList.forEach((product) -> product.setOrder(order));
        orderProductSellerRepository.saveAll(orderProductSellerList);

        TotalPriceResponseDTO responseDTO = TotalPriceResponseDTO
                .builder()
                .totalPrice(orderTotal)
                .build();

        if (!responseErrorList.isEmpty()) {
            responseDTO.setProductErrorDto(responseErrorList);
        }
        return responseDTO;
    }

    private ProductPurchaseOrderCheckDTO performChecksOnProductList(
            List<ProductPurchaseOrderRequestDto> purchaseOrderRequestDtos
    ) {
        List<OrderProductSeller> orderProductSellerList = new ArrayList<>();
        List<SimpleProductErrorDto> responseErrorList = new ArrayList<>();
        double orderTotal = 0.0;

        for (ProductPurchaseOrderRequestDto product : purchaseOrderRequestDtos) {
            Optional<ProductSeller> productSellerOpt = productSellerRepository
                    .findById(Long.valueOf(product.getProductId()));
            if (productSellerOpt.isEmpty()) {
                responseErrorList.add(
                        SimpleProductErrorDto
                                .builder()
                                .productId(product.getProductId())
                                .errorDescription(MessageError.PRODUCTS_NOT_FOUND.getMessage())
                                .build()
                );
                continue;
            }
            ProductSeller productSeller = productSellerOpt.get();

            Optional<Batch> batchOpt = batchRepository.findBatchesByProductSellerId(productSeller.getId());
            if (batchOpt.isEmpty()) {
                responseErrorList.add(
                        SimpleProductErrorDto
                                .builder()
                                .productId(product.getProductId())
                                .errorDescription(MessageError.PRODUCTS_BATCH_NOT_FOUND.getMessage())
                                .build()
                );
                continue;
            }
            Batch batch = batchOpt.get();
            if (batch.getCurrentQuantity() <= 0) {
                responseErrorList.add(
                        SimpleProductErrorDto
                                .builder()
                                .productId(product.getProductId())
                                .errorDescription(MessageError.PRODUCTS_STOCK.getMessage())
                                .build()
                );
                continue;
            }

            LocalDate dueDate = batch.getDueDate();
            LocalDate acceptableDueDate = LocalDate.now().plusWeeks(3);
            if (dueDate.isBefore(acceptableDueDate)) {
                responseErrorList.add(
                        SimpleProductErrorDto
                                .builder()
                                .productId(product.getProductId())
                                .errorDescription(MessageError.PRODUCTS_EXPIRED.getMessage())
                                .build()
                );
                continue;
            }

            double productTotal = product.getQuantity().doubleValue() * productSeller.getPrice().doubleValue();
            orderProductSellerList.add(
                    OrderProductSeller
                            .builder()
                            .productSeller(productSeller)
                            .quantity(product.getQuantity())
                            .price(BigDecimal.valueOf(productTotal))
                            .build()
            );

            orderTotal += productTotal;
        }

        return ProductPurchaseOrderCheckDTO.builder()
                .orderProductSellerList(orderProductSellerList)
                .orderTotal(orderTotal)
                .responseErrorList(responseErrorList)
                .build();
    }
}
