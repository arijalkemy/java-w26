package com.mercadolibre.fresh_market.config.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.model.CartDetail;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.PurchaseOrder;
import com.mercadolibre.fresh_market.model.ShoppingCartKey;
import com.mercadolibre.fresh_market.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private ISectionRepository sectionRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IPurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private ICartDetailRepository cartDetailRepository;

    @Autowired
    private IInboundOrderRepository inboundOrderRepository;

    @Autowired
    private IBatchRepository batchRepository;

    @PostConstruct
    @Profile("prod")
    public void loadJsonData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("datasourceLoad.json").getInputStream();
        Data data = mapper.readValue(inputStream, Data.class);

        userRepository.saveAll(data.getUsers());
        productRepository.saveAll(data.getProducts());
        warehouseRepository.saveAll(data.getWarehouses());
        sectionRepository.saveAll(data.getSections());
        inboundOrderRepository.saveAll(data.getInbound_orders());
        batchRepository.saveAll(data.getBatches());
        purchaseOrderRepository.saveAll(data.getPurchase_orders());

        List<PurchaseOrder> allPurchaseOrders = purchaseOrderRepository.findAll();
        List<Product> allProducts = productRepository.findAll();
        for (CartDetail cartDetailDto : data.getCart_details()) {
            try {
                Long purchaseOrderId = cartDetailDto.getId().getOrderId();
                Long productId = cartDetailDto.getId().getProductId();
                PurchaseOrder purchaseOrder = allPurchaseOrders.stream()
                        .filter(order -> order.getId().equals(purchaseOrderId))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("PurchaseOrder not found for id: " + purchaseOrderId));
                Product product = allProducts.stream()
                        .filter(p -> p.getId().equals(productId))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Product not found for id: " + productId));
                ShoppingCartKey key = new ShoppingCartKey(purchaseOrder.getId(), product.getId());
                CartDetail cartDetail = new CartDetail(key, purchaseOrder, product, cartDetailDto.getQuantity());
                cartDetailRepository.save(cartDetail);
            } catch (Exception e) {
                // Log the exception and details for better debugging
                e.printStackTrace();
                // Handle or rethrow the exception as appropriate for your application
                throw new RuntimeException("Error processing CartDetail: " + e.getMessage());
            }
        }
    }
}
