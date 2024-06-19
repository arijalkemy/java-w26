package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.util;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;

import java.util.List;

public class TestGeneratorUtil {

    public static List<InventoryByWarehouseDto> getInvByWh() {
        return List.of(new InventoryByWarehouseDto(1, 100L));
    }

    public static CheckInventoryResponseDto getCheckInvResponse() {
        return new CheckInventoryResponseDto(1, getInvByWh());
    }

    public static ProductCrudResponseDto getResponseSatisfactory() {
        return new ProductCrudResponseDto(200, "Productos creados", 202);
    }

    public static ProductCrudResponseDto getResponseSatisfactoryToMod() {
        return new ProductCrudResponseDto(200, "Se actualizo el proceso de manera correcta", 200);
    }

    public static ProductCrudResponseDto getResponseSatisfactoryToDelete() {
        return new ProductCrudResponseDto(200, "Se ha eliminado el registro", 202);
    }

    public static Category getCategoryTest() {
        return new Category(4, "DF");
    }

    public static ProductListDto getProductToSendList() {
        return new ProductListDto(List.of(new ProductInfoDto("1", 200.0)));
    }

    public static Product productToMod(){
        return new Product(1, getCategoryTest(),"ProductoPrueba",200.0);
    }

    public static ProductInfoDto productInfoToMod(){
        return new ProductInfoDto("ProductoPrueba",200.0);
    }

    public static List<AllProductsBySellerDto> getAllProductsBySeller(){
        return List.of(new AllProductsBySellerDto(1,"Producto1",200.0,4,"DF"));
    }

    public static ProductListDto getProductListCtrl(){
        ProductInfoDto productInfoDto = new ProductInfoDto("Product1",200.0);
        return new ProductListDto(List.of(productInfoDto));
    }

}
