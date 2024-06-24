package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.PostsByFollowedUsersDTO;

public interface IProductService {
    PostsByFollowedUsersDTO getPostByFollowedUsers(int userId, String order);
}
