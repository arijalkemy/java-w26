package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.*;
import com.mercadolibre.project_java_w26_team13.entity.Batch;
import com.mercadolibre.project_java_w26_team13.entity.Cart;
import com.mercadolibre.project_java_w26_team13.entity.CartDetail;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.IBatchRepository;
import com.mercadolibre.project_java_w26_team13.repository.ICartDetailRepository;
import com.mercadolibre.project_java_w26_team13.repository.ICartRepository;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {
    private final JWTClaims jwtClaims;
    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;
    private final ICartRepository cartRepository;
    private final ICartDetailRepository cartDetailRepository;

    CartService(JWTClaims jwtClaims,
                IProductRepository productRepository,
                IBatchRepository batchRepository,
                ICartRepository cartRepository,
                ICartDetailRepository cartDetailRepository) {
        this.jwtClaims = jwtClaims;
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    @Override
    public CartResponseDto createCart(String authorizationHeader, CartRequestDto cartRequestDto) {
        jwtClaims.validateHeader(authorizationHeader, Roles.BUYER.getRole());

        double totalPrice = 0.0;
        PurchaseOrderDto purchaseOrderDto = cartRequestDto.getPurchaseOrderDto();
        int buyerId = purchaseOrderDto.getBuyerId();
        List<CartProductDto> products = purchaseOrderDto.getProducts();
        String status = purchaseOrderDto.getOrderStatusDto().getStatusCode();
        List<String> productsWithoutStock = new ArrayList<>();

        Cart cart = Cart.builder()
                .date(LocalDate.now())
                .buyerId(buyerId)
                .status(status)
                .cartDetails(new ArrayList<>())
                .totalPrice(totalPrice)
                .build();

        for (CartProductDto productDto : products) {
            Product product = productRepository.findById(productDto.getProductId())
                    .orElseThrow(() ->
                            ExceptionsFactory.notFoundException(
                                    "product with id: " + productDto.getProductId() + " does not exist"
                            ));

            List<Batch> batch = batchRepository.findByProductId(productDto.getProductId());

            int currentQuantity = batch.stream().filter(b -> b.getDueDate().isAfter(LocalDate.now())).mapToInt(Batch::getCurrentQuantity).sum();

            if (currentQuantity >= productDto.getQuantity()) {
                totalPrice += product.getPrice() * productDto.getQuantity();

                CartDetail cartDetail = CartDetail.builder()
                        .cart(cart)
                        .quantity(productDto.getQuantity())
                        .unitPrice(product.getPrice())
                        .product(product)
                        .build();
                cart.getCartDetails().add(cartDetail);
            } else {
                productsWithoutStock.add(product.getName());
            }
        }

        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
        cartDetailRepository.saveAll(cart.getCartDetails());

        return CartResponseDto.builder().totalPrice(totalPrice).productsWithoutStock(productsWithoutStock).build();
    }

    @Override
    public CartRequestDto searchCart(String authorizationHeader, Long orderId) {
        jwtClaims.validateHeader(authorizationHeader,Roles.BUYER.getRole());

        Cart cart = cartRepository.findById(orderId).orElse(null);
        if (cart == null) {
            throw ExceptionsFactory.notFoundException("Cart with id " + orderId + " not found.");
        } else {
            List<CartDetail> cartDetails = cart.getCartDetails();
            List<CartProductDto> productDTOList = new ArrayList<>();
            for (CartDetail detail : cartDetails) {
                Product product = detail.getProduct();
                productDTOList.add(new CartProductDto(product.getId(), detail.getQuantity(), null));
            }
            PurchaseOrderDto orderDTO = new PurchaseOrderDto(
                    cart.getDate().toString(), cart.getBuyerId(), new OrderStatusDto(cart.getStatus()), productDTOList
            );

            return new CartRequestDto(orderDTO);
        }
    }

    @Override
    public CartResponseDto updateCart(String authorizationHeader, Long orderId, CartRequestDto cartRequestDto){
        jwtClaims.validateHeader(authorizationHeader, Roles.BUYER.getRole());

        Cart cart = cartRepository.findById(orderId).get();
        if(cart == null){
            throw ExceptionsFactory.notFoundException("Order not found.");
        }
        List<CartDetail> cartDetailList = new ArrayList<>();
        List<Product> productList = productRepository.findAllById(cartRequestDto.getPurchaseOrderDto().getProducts().stream().map(x -> x.getProductId()).toList());

        for(CartProductDto cartProductDto :  cartRequestDto.getPurchaseOrderDto().getProducts()){
            CartDetail cartDetail;
            if(cartProductDto.getCartDetailId() != null){
                cartDetail = cart.getCartDetails().stream().filter(c -> c.getId() == cartProductDto.getCartDetailId()).findFirst().get();
            } else {
                cartDetail = new CartDetail();
            }
            Product product = productList.stream().filter(p -> p.getId() == cartProductDto.getProductId()).findFirst().get();
            cartDetail.setQuantity(cartProductDto.getQuantity());
            cartDetail.setProduct(product);
            cartDetail.setUnitPrice(product.getPrice());
            cartDetailList.add(cartDetail);
        }

        cart.setCartDetails(cartDetailList);
        Double total = cart.getCartDetails().stream().collect(Collectors.summingDouble(x -> x.getUnitPrice() * x.getQuantity()));
        cart.setTotalPrice(total);
        cartRepository.save(cart);
        return new CartResponseDto(total, null);
    }
}
