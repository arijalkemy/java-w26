package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ExceptionDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostPromoDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponsePromoPostDTO;

import java.util.List;

public interface IPostService {

    ExceptionDto create(PostDTO postDto);

    PostPromoDTO createPromoPost(PostPromoDTO postPromoDTO);

    ResponsePromoPostDTO getPromoPostCount(int userId);

    List<PostPromoDTO> getPostByUser(int userId, String month, String year);
}
