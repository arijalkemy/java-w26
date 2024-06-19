package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.ProductAvailabilityDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.PurchaseValueResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.*;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.IFrescosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class FrescosServiceImpl implements IFrescosService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IShoppingCartRepository shoppingCartRepository;
    @Autowired
    IShoppingCartProductRepository shoppingCartProductRepository;
    @Autowired
    IBatchRepository batchRepository;
    @Autowired
    IProductRepository productRepository;
    @Override
    /**
     * US-2-ISSUE-5
     * En este metodo hacemos uso de tres funciones auxiliares, una para buscar los productos que cumplan con las
     * reglas de negocio, otra para guardar la orden y otra para guardar los productos de la orden, posteriormente
     * calculamos el precio del carrito y lo devolvemos de acuerdo a la especificacion tecnica
     */
    @Transactional
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order) {
        List<ProductAvailabilityDto> complyingProducts = getProductsWithExpirationGreaterThanThreeWeeks(order);
        ShoppingCart cart = purchaseOrderSave(order);
        saveCartProducts(cart,complyingProducts);
        PurchaseValueResponseDto purchaseValue = new PurchaseValueResponseDto(0.0);
        complyingProducts.forEach(e->purchaseValue.setTotal(
                purchaseValue.getTotal() + e.getBatch().getProduct().getPrice() * e.getQuantity()
        ));
        return purchaseValue;
    }
    /**
     * US-2-ISSUE-5
     * En esta funcion auxiliar creamos una nueva orden, le aniadimos los productos y la guardamos en BD
     */
    @Transactional
    public ShoppingCart purchaseOrderSave(PurchaseOrderDto order){
        ShoppingCart cart = new ShoppingCart();
        UserAccount userFromOrder = userRepository.findUserAccountByUserId(order.getDetails().getBuyerId().longValue());
        cart.setOrderDate(order.getDetails().getDate());
        cart.setOrderState(order.getDetails().getOrderStatus().getStatusCode());
        cart.setUser(userFromOrder);
        shoppingCartRepository.save(cart);
        return cart;
    }
    /**
     * US-2-ISSUE-5
     * En esta funcion auxiliar iremos en busca de los productos que cumplan con la regla de no exceder en tres semanas
     * desde ahora la fecha de vencimiento, apoyados claramente en un (super)query method :)
     */
    @Transactional
    public List<ProductAvailabilityDto> getProductsWithExpirationGreaterThanThreeWeeks(PurchaseOrderDto order){
        LocalDate threeWeeksExpirationLimit = LocalDate.now().plusWeeks(3);
        List<ProductAvailabilityDto> checkedProducts = new ArrayList<>();
        order.getDetails().getProducts().forEach(e -> {
            List<Batch> batch =
                    batchRepository.findByProductIdAndDueDateAfterAndCurrentQuantityGreaterThanEqual(e.getProductId(),threeWeeksExpirationLimit,e.getQuantity());
            if(!batch.isEmpty()) checkedProducts.add(new ProductAvailabilityDto(batch.get(0),e.getProductId(),e.getQuantity()));
            System.out.println(batchRepository.findByDueDateBefore(threeWeeksExpirationLimit).size());
        });
        if(checkedProducts.isEmpty()) {
            throw new NotFoundException("No tienes productos validos en el carrito");
        }
        return checkedProducts;
    }
    /**
     * US-2-ISSUE-5
     * En esta metodo guardamos los productos que efectivamente cumplan con las reglas de negocia y han sido aniadidos
     * a gusto del usuario
     */
    @Transactional
    public void saveCartProducts(ShoppingCart order,List<ProductAvailabilityDto> complyingProducts){
        complyingProducts.forEach(e->{
            Optional<Product> product = productRepository.findById(e.getProductId());
            product.ifPresent(val -> shoppingCartProductRepository.save(new ShoppingCartProduct(order.getId(), order,val,e.getQuantity())));
        });
    }
    /**
     * US-2-ISSUE-6 View products from cart service
     *
     * En esta implementacion hacemos llamado al query method dentro del repo
     * El cual nos trae una lista de Productos de una order
     * posteriormente lo mapeamos a un Set para que traiga productos unicos
     * y no una lista con todos los valores repetidos
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Set<ProductDto> getProductsFromShoppingCart(Integer id) {
        List<ShoppingCartProduct> productsFromShoppingCart =
                shoppingCartProductRepository.findDistinctByShoppingCartId(id);
        List<ProductDto> productsFromCartMapped =
                productsFromShoppingCart
                        .stream()
                        .map(e-> new ProductDto(e.getProduct().getName(),e.getProduct().getPrice())).toList();
        return new HashSet<>(productsFromCartMapped);
    }
}
