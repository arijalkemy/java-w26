package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.ProductBestSellingDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderRequestBodyDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.order.PurchaseOrderResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCartProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IShoppingCartProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IShoppingCartRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {
    IShoppingCartRepository shoppingCartRepository;
    IProductRepository productRepository;
    IUserAccountRepository userAccountRepository;
    IShoppingCartProductRepository shoppingCartProductRepository;
    public ShoppingCartServiceImpl(
           @Autowired IShoppingCartRepository shoppingCartRepository,
           @Autowired IProductRepository productRepository,
           @Autowired IUserAccountRepository userAccountRepository,
           @Autowired IShoppingCartProductRepository shoppingCartProductRepository
    ) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.userAccountRepository = userAccountRepository;
        this.shoppingCartProductRepository = shoppingCartProductRepository;
    }

    /**
     * Service for update the products of a existing order
     * @param orderId
     * @param purchaseOrderRequestBodyDto
     * @return {@link PurchaseOrderResponseDto} the total of the order with the update
     */
    @Override
    public PurchaseOrderResponseDto modifyPurchaseOrder(Integer orderId, PurchaseOrderRequestBodyDto purchaseOrderRequestBodyDto) {
        /* get the purchase order */
        PurchaseOrderRequestDto purchaseOrder = purchaseOrderRequestBodyDto.getPurchaseOrderRequestDto();

        /* Validate if the order exists */
        Optional<ShoppingCart> shoppingCartExists = shoppingCartRepository.findById(orderId);
        if(shoppingCartExists.isEmpty()){
            String message = String.format("The order with the id: %d does not exist", orderId);
            throw new NotFoundException(message);
        }

        /* Validate if the user exist */
        Optional<UserAccount> buyer = userAccountRepository.findById(purchaseOrder.getBuyer_id().longValue());
        if(!buyer.isPresent()){
            String message = String.format("The buyer with the id %d does not exist", purchaseOrder.getBuyer_id());
            throw new NotFoundException(message);
        }

       /* Validate if the user is owner of the order */
        if(!shoppingCartExists.get().getUser().getUserId().equals(purchaseOrderRequestBodyDto.getPurchaseOrderRequestDto().getBuyer_id().longValue())){
            String message = String.format("The buyer with the id %d does not own the order with the id %d",
                    purchaseOrder.getBuyer_id(),
                    orderId);
            throw new BadRequestException(message);
        }

        /* Validate the shopping cart status */
        if(!purchaseOrderRequestBodyDto.getPurchaseOrderRequestDto().getOrder_status().getStatus_code().equals("shopping_cart")){
            throw new BadRequestException("The status of the purchase order must be 'shopping_cart'");
        }

        /* Validate if all the products exist */
        List<Product> productsWithStock = purchaseOrder.getProducts()
                .stream()
                .map(product -> productRepository.findById(product.getProduct_id())
                    .orElseThrow(() -> new NotFoundException("Product not found with the ID: " +
                            product.getProduct_id())))
                .toList();



        /* Validate the quantity of the products, must be at least 1 */
        for(PurchaseOrderProduct productFromPurchaseOrder: purchaseOrder.getProducts()){
            if(productFromPurchaseOrder.getQuantity() <= 0){
                String message = String.format("The product with the ID: %d must have at least 1 on quantity",
                        productFromPurchaseOrder.getQuantity());
                throw new BadRequestException(message);
            }
        }

        /* Convert the products from the purchase order to products to be in the shopping cart */
        List<ShoppingCartProduct> products = purchaseOrder.getProducts()
                .stream()
                .map(productFromPurchaseOrder -> ShoppingCartProduct
                        .builder()
                        .shoppingCart(shoppingCartExists.get())
                        .product(productsWithStock.stream().filter(productWithStock ->
                                productWithStock.getId() == productFromPurchaseOrder.getProduct_id())
                                .findFirst().get())
                        .quantity(productFromPurchaseOrder.getQuantity())
                        .build()
                )
                .toList();

        /* Save the new items in the shopping-cart-product table */
        shoppingCartProductRepository.saveAll(products);

        /* Calculate the total of the purchase order */
        Double purchaseOrderTotal = purchaseOrder.getProducts()
                .stream()
                .mapToDouble(productFromPurchaseOrder ->
                        productFromPurchaseOrder.getQuantity() *
                        productRepository.findById(productFromPurchaseOrder.getProduct_id()).get().getPrice()
                )
                .sum();

        return PurchaseOrderResponseDto.builder()
                .total_price(purchaseOrderTotal)
                .build();
    }

    @Override
    public Double getTotalSalesForMonth(Integer idWarehouse) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        Double totalSales = shoppingCartRepository.getTotalSalesForMonth(idWarehouse,thirtyDaysAgo);
        if (totalSales == null)
            throw new NotFoundException("data not found");
        return totalSales;
    }

    @Override
    public List<ShoppingCart> getSalesInLastMonth(Integer idWarehouse) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findSalesInLastMonth(idWarehouse,thirtyDaysAgo);
        if (shoppingCarts.isEmpty())
            throw new NotFoundException("data not found");
        return shoppingCarts;
    }

    @Override
    public List<ProductBestSellingDto> findBestSellingProductInLastMonth(Integer idWarehouse) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        List<ProductBestSellingDto> productBestSelling = shoppingCartProductRepository
                .findBestSellingProductInLastMonth(idWarehouse,thirtyDaysAgo);
        if (productBestSelling.isEmpty())
            throw new NotFoundException("data not found");
        return productBestSelling;
    }

    @Override
    public Double getTotalProductsSalesForMonth(Integer idWarehouse) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        Double totalProducts = shoppingCartProductRepository.getTotalProductsSalesForMonth(idWarehouse,thirtyDaysAgo);
        if (totalProducts == null)
            throw new NotFoundException("data not found");
        return totalProducts;
    }
}
