package com.mercadolibre.sprint_3_team_12.service;
import com.mercadolibre.sprint_3_team_12.dto.request.CartDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.OrderStatusDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.PurchaseOrderDTO;
import com.mercadolibre.sprint_3_team_12.entity.Cart;
import com.mercadolibre.sprint_3_team_12.entity.User;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiException;
import com.mercadolibre.sprint_3_team_12.repository.ICartRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService{

    @Autowired
    private ICartRepository cartRepository;


    ModelMapper modelMapper = new ModelMapper();

    /**
     * Get all products in the cart.
     * @param idOrder - id of the cart.
     * @return CartDTO with all products in the cart.
     */
    @Override
    @Transactional
    public CartDTO getCart(Long idOrder) {
        Optional<Cart> cartOptional = cartRepository.findById(idOrder);
        if (cartOptional.isEmpty()) {
            throw new ApiException("Not Found", "The cart with the given id: " + idOrder + " was not found.", HttpStatus.NOT_FOUND.value());
        }

        Cart cart = cartOptional.get();

        // Validate fields
        validateCartFields(cart, idOrder);

        // Create DTOs
        PurchaseOrderDTO purchaseOrderDTO = createPurchaseOrderDTO(cart);

        return new CartDTO(purchaseOrderDTO);
    }

    /**
     * Validate the fields of the cart.
     * @param cart - Cart to validate.
     * @param idOrder - id of the cart.
     * @throws ApiException if any field is invalid.
     */
    private void validateCartFields(Cart cart, Long idOrder) {

        // Validate buyer and buyer ID
        if (cart.getBuyer() == null || cart.getBuyer().getId() == null) {
            throw new ApiException("Validation Error", "Buyer field or Buyer ID is required for cart id: " + idOrder, HttpStatus.BAD_REQUEST.value());
        }

        // Validate orderStatus
        if (cart.getOrderStatus() == null) {
            throw new ApiException("Validation Error", "OrderStatus field is required for cart id: " + idOrder, HttpStatus.BAD_REQUEST.value());
        }

        // Validate products
        if (cart.getProducts() == null || cart.getProducts().isEmpty()) {
            throw new ApiException("Validation Error", "Products field must not be empty for cart id: " + idOrder, HttpStatus.BAD_REQUEST.value());
        }
    }

    /**
     * Create a PurchaseOrderDTO from a Cart.
     * @param cart - Cart to create the PurchaseOrderDTO.
     * @return PurchaseOrderDTO created.
     */
    private PurchaseOrderDTO createPurchaseOrderDTO(Cart cart) {
        User buyer = cart.getBuyer();
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO(cart.getOrderStatus().toString());
        List<ProductDTO> productDTOList = cart.getProducts().stream()
                .map(productInCart -> modelMapper.map(productInCart, ProductDTO.class))
                .collect(Collectors.toList());

        return new PurchaseOrderDTO(
                cart.getCarDate(), Math.toIntExact(buyer.getId()), orderStatusDTO, productDTOList
        );
    }

}
