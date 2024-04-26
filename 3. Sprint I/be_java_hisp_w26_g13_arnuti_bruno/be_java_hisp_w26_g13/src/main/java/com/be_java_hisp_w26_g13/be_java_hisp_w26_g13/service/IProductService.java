package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostsByFollowedUsersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ProductDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;

public interface IProductService {
    ProductDTO convertToProductDTO(Product product);

    PostsByFollowedUsersDTO getPostByFollowedUsers(int userId, String order);
}
