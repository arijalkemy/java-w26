package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostsByFollowedUsersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseVendorPromoCountDTO;

public interface IProductService {
    PostsByFollowedUsersDTO getPostByFollowedUsers(int userId, String order);
    ResponseVendorPromoCountDTO gerUserPromos(int userId);
}
