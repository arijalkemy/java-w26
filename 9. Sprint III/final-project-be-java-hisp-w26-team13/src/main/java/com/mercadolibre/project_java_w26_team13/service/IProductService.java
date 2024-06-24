package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
List<ProductDto> getProductList(String authorizationHeader);

List<ProductDto> getProductListByCategory(String authorizationHeader, String category);
}
