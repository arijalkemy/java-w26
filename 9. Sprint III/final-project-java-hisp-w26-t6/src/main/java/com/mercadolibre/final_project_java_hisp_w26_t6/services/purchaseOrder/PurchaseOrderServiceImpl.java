package com.mercadolibre.final_project_java_hisp_w26_t6.services.purchaseOrder;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductPurchaseOrderDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderInsertRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.*;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.BadRequestException;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_hisp_w26_t6.mappers.PurchaseOrderMapper;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IBatchesRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IProductsRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IPurchaseOrderRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IUsersRepository;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    IProductsRepository productsRepository;

    @Autowired
    IPurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    IBatchesRepository batchesRepository;

    @Transactional
    @Override
    public PurchaseOrderPostResponseDto addPurchaseOrder(PurchaseOrderInsertRequestDto order) {
        PurchaseOrder purchaseOrder = mapPurchaseOrderDtoToPurchaseOrder(order.getPurchaseOrderDto());
        PurchaseOrderPostResponseDto responseDto = checkProductStockAndGenerateResponse(purchaseOrder);
        purchaseOrderRepository.save(purchaseOrder);
        return responseDto;
    }

    @Transactional(readOnly = true)
    @Override
    public PurchaseOrderProductsResponseDto getPurchaseOrderProducts(Long idOrder) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(idOrder).orElseThrow(
                () -> new NotFoundException("Purchase Order with id: " + idOrder + " not found")
        );
        return PurchaseOrderMapper.buildPurchaseOrderProductsResponseDto(purchaseOrder.getPurchaseOrderDetails()
                .stream()
                .map(PurchaseOrderMapper::purchaseOrderDetailToPurchaseOrderProductResponseDto)
                .toList());
    }

    @Transactional
    @Override
    public PurchaseOrderPostResponseDto updatePurchaseOrder(PurchaseOrderInsertRequestDto order, Long idOrder) {
        PurchaseOrder existingOrder = purchaseOrderRepository.findById(idOrder).orElseThrow(
                () -> new NotFoundException("Purchase Order with id: " + idOrder + " not found")
        );
        PurchaseOrder overWritingOrder = mapPurchaseOrderDtoToPurchaseOrder(order.getPurchaseOrderDto());

        PurchaseOrderPostResponseDto responseDto = checkProductStockAndGenerateResponse(overWritingOrder);

        overWritingOrder.setId(existingOrder.getId());
        purchaseOrderRepository.save(overWritingOrder);
        return responseDto;
    }

    private PurchaseOrderPostResponseDto checkProductStockAndGenerateResponse(PurchaseOrder purchaseOrder) {
        List<String> warnings = new ArrayList<>();
        List<Product> missingProducts = new ArrayList<>();
        purchaseOrder.getPurchaseOrderDetails()
                .forEach(purchaseOrderDetail -> {
                    Product curProduct = purchaseOrderDetail.getProduct();
                    if (getAvailableQuantityForProduct(curProduct) < purchaseOrderDetail.getQuantity()) {
                        warnings.add("There's not enough stock of " + curProduct.getName() +
                                ". They will be removed from the cart.");
                        missingProducts.add(curProduct);
                    }
                });
        if (!warnings.isEmpty()) {
            purchaseOrder.setPurchaseOrderDetails(
                    buildOrderDetailList(purchaseOrder, missingProducts)
            );
            return PurchaseOrderMapper.buildPurchaseOrderPostResponseWithWarningsDto
                    (getPurchaseOrderTotalPrice(purchaseOrder), warnings);
        }
        return PurchaseOrderMapper.buildPurchaseOrderPostResponseWithoutWarningsDto
                (getPurchaseOrderTotalPrice(purchaseOrder));
    }

    private static List<PurchaseOrderDetail> buildOrderDetailList(PurchaseOrder purchaseOrder, List<Product> missingProducts) {
        return purchaseOrder.getPurchaseOrderDetails()
                .stream()
                .filter(purchaseOrderDetail ->
                        !missingProducts.contains(purchaseOrderDetail.getProduct()))
                .toList();
    }

    private int getAvailableQuantityForProduct(Product curProduct) {
        return batchesRepository.findAllByProduct(curProduct)
                .stream()
                .filter(batch -> batch.getDueDate()
                        .isAfter(LocalDate.now().plusWeeks(3).atStartOfDay()))
                .mapToInt(Batch::getQuantity)
                .sum();
    }

    private double getPurchaseOrderTotalPrice(PurchaseOrder purchaseOrder) {
        return purchaseOrder.getPurchaseOrderDetails()
                .stream()
                .mapToDouble(o -> o.getProduct().getUnitPrice() * o.getQuantity())
                .sum();
    }

    private PurchaseOrder mapPurchaseOrderDtoToPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        User buyer = validateBuyer(purchaseOrderDto.getBuyerId());
        List<PurchaseOrderDetail> productsDetails = mapPurchaseOrderDtoToDetail(purchaseOrderDto.getProducts());

        return PurchaseOrderMapper.toPurchaseOrder(buyer, productsDetails, purchaseOrderDto);
    }

    private List<PurchaseOrderDetail> mapPurchaseOrderDtoToDetail(List<ProductPurchaseOrderDto> purchaseOrderDtos) {
        return purchaseOrderDtos.stream().map(p ->
                PurchaseOrderMapper.toPurchaseOrderDetails(validateProduct(p.getProductId()), p.getQuantity()))
                .toList();
    }

    private Product validateProduct(Long productId) {
        return productsRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product with id: " + productId + " not found"));
    }

    private User validateBuyer(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("Buyer with id: " + userId + " not found"));
        if (!user.getUserRole().equals(UserRoles.BUYER)) {
            throw new BadRequestException("User is not buyer");
        }
        return user;
    }
}
